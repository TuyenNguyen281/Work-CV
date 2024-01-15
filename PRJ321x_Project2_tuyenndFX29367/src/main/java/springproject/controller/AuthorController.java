package springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import springproject.config.userdetail.UserPrinciple;
import springproject.entity.ConfirmationToken;
import springproject.entity.Role;
import springproject.entity.User;
import springproject.service.ConfirmationTokenService;

import springproject.service.RoleService;
import springproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    SecurityContextLogoutHandler securityContextLogoutHandler;
    @Autowired
    private MailSender mailSender;

    @GetMapping("/showMyLoginPage")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "loginForm";
    }

    //--------------Chức năng đăng kí------------------------------
    @PostMapping("/register")
    public RedirectView register(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        String message = "";
        System.out.println(user);
        if(!user.getPassword().equals(user.getConfirmPassword())) {   //Check password và confirm password khác nhau
            message = "Password and ConfirmPassword different";
            RedirectView redirectView = new RedirectView("/author/showMyLoginPage", true);
            redirectAttributes.addFlashAttribute("message", message);
            return redirectView;
        }


        User existingUser = userService.findUserByEmail(user.getEmail());   //TÌm kiếm user theo email
        if (existingUser != null) {
            message = "This email already exists!!!:   " + user.getEmail();
        } else {
            Role role = roleService.getRoleByName(user.getRole().getRoleName()); //Set quyền cho user
            if (role == null) {
                roleService.saveRole(user.getRole());
            } else {
                user.setRole(role);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
            try {
                userService.saveUser(user);                     //Lưu user
                message = "Success!!!:   " + user.getFullName();

            } catch (Exception e) {
                message = "Fail!!!:   " + user.getFullName();
                System.out.println(e.getMessage());
            }
            try {
                if (user.getRole().getRoleName().equals("ROLE_CTY")) {          //Check user có quyền "ROLE_CTY" thì gửi mail xác nhận
                    ConfirmationToken confirmationToken = new ConfirmationToken(user);
                    confirmationTokenService.saveConfirmationToken(confirmationToken);
                    String from = "tuyennuce1@gmail.com";
                    String to = user.getEmail();
                    String subject = "Complete Registration!";
                    String content = "To confirm your account, please click here : " + "http://localhost:8080/author/confirm-account?token=" + confirmationToken.getConfirmationToken();
                    sendEmail(from, to,subject,content);                    //Gủi mail xác nhận

                    message = "Success!!!:   " + user.getFullName() + "..." + "\n" + "You need to log in to your email for verification." + "\n" +
                            "If you don't see it, you can check your spam or trash";
                }
            } catch (Exception e) {
                message = "Fail!!!:   " + user.getFullName();
            }
        }
        RedirectView redirectView = new RedirectView("/author/showMyLoginPage", true);
        redirectAttributes.addFlashAttribute("message", message);
        return redirectView;
    }

    //----------------confirm account khi click vào đường dẫn trong mail nhận đc
    @GetMapping(value = "/confirm-account")
    public RedirectView confirmUserAccount(@RequestParam("token") String confirmationToken, RedirectAttributes redirectAttributes) {
        String message = "";
        ConfirmationToken token = confirmationTokenService.findByConfirmationToken(confirmationToken);
        if (token != null) {
            User user = userService.findUserByEmail(token.getUser().getEmail());
            System.out.println("status1: " + user.getStatus());
            user.setStatus("ACTIVE");
            System.out.println("status2: " + user.getStatus());
            userService.saveUser(user);
            message = "Account Verified!!!";
        } else {
            message = "The link is invalid or broken!!!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        RedirectView redirectView = new RedirectView("/author/showMyLoginPage", true);
        return redirectView;
    }

    //------------------Chức năng login -----------------------------
    @PostMapping("/login")
    public RedirectView login(User user, RedirectAttributes redirectAttributes) {
        String login_message_success = "";
        String login_message_fail = "";
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);

            redirectAttributes.addFlashAttribute("login_message_success", login_message_success);

        } catch (AuthenticationException e) {

            redirectAttributes.addFlashAttribute("login_message_fail", login_message_fail);
        }
        RedirectView redirectView = new RedirectView("/home/", true);

        return redirectView;
    }
    //--------------------Chức năng logout-----------------------------------
    @GetMapping("/logout")
    public RedirectView logout( Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(authentication);
        securityContextLogoutHandler.logout(request, response,authentication);
        RedirectView redirectView = new RedirectView("/home/", true);
        return redirectView;
    }
    //---------------Method gửi email----------------------------------
    private void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
    }




}
