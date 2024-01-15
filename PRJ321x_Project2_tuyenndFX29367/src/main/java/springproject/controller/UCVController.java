package springproject.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import springproject.config.userdetail.UserPrinciple;
import springproject.entity.*;
import springproject.model.ApplyJobModel;
import springproject.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/UCV")
public class UCVController {
    @Autowired
    private UserService userService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CVService cvService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private ApplyPostService applyPostService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FollowCompanyService followCompanyService;

    @Autowired
    private SaveJobService saveJobService;

//------------Hiển thị profile user ----------------------
    @GetMapping("/")
    public String profile(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId());//Get user đang đăng nhập hệ thống
        model.addAttribute("user", user);
        CV cv = cvService.findCVByUser(user);  //Get CV của user
        if (cv == null) {
            model.addAttribute("cv", new CV());
        } else {
            model.addAttribute("cv", cv);
        }

        return "profile";
    }

//---------------Updade profile của user----------------------------
    @PostMapping("/update-profile")
    public RedirectView updateProfile(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        String update_message_success = "";
        String update_message_fail = "";
        System.out.println(user);
        try {
            if (!user.getMultipartFile().isEmpty()) {  //Check file gửi kèm trong thông tin của user có không
                Map result = cloudinary.uploader().upload(user.getMultipartFile().getBytes(), ObjectUtils.asMap("resource_type", "auto")); //Upload file lên Cloudinary
                String image = (String) result.get("secure_url");   //Lấy đường dẫn file do Cloudinary gửi về
                user.setImage(image);
            }
            Role role = roleService.getRoleByName(user.getRole().getRoleName());
            user.setRole(role);
            userService.saveUser(user);  //Lưu thông tin user
            redirectAttributes.addFlashAttribute("update_message_success", update_message_success);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("update_message_fail", update_message_fail);
            e.printStackTrace();
        }

        RedirectView redirectView = new RedirectView("/UCV/", true);
        return redirectView;
    }
    //----------------Update CV của user-----------------------
    @PostMapping("/update-cv")
    public RedirectView updateCV(@ModelAttribute("cv") CV cv, RedirectAttributes redirectAttributes) {
        String update_message_success = "";
        String update_message_fail = "";
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId()); //Get user đang đăng nhập hệ thống
        cv.setUser(user);
        try {
            if (!cv.getMultipartFile().isEmpty()) {//Check file có gửi không
                Map result = cloudinary.uploader().upload(cv.getMultipartFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));  //Upload file lên Cloudinary
                String linkCv = (String) result.get("secure_url"); //Lấy đường dẫn file do Cloudinary gửi về

                cv.setLinkCV(linkCv);
                String name = cv.getMultipartFile().getOriginalFilename();
                cv.setName(name);
                cvService.saveCV(cv); //Lưu CV
                redirectAttributes.addFlashAttribute("update_message_success", update_message_success);
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("update_message_fail", update_message_fail);
        }
        RedirectView redirectView = new RedirectView("/UCV/", true);
        return redirectView;
    }

    //---------------Apply job------------------------
    @PostMapping("/apply-job")
    public @ResponseBody
    String applyJob(@ModelAttribute("formData") ApplyJobModel applyJobModel) {
        String message_apply = "";
        User user = userService.findUserById(applyJobModel.getUserId());
        Recruitment recruitment = recruitmentService.findRecruitmentById(applyJobModel.getRecruitmentId());
        ApplyPost applyPost = applyPostService.findApplyPostByUserAndRecruitment(user, recruitment);  //Get ApplyPost theo  User và Recruitment

        if (applyPost != null) { //Check user đã từng apply Recruitment này chưa
            message_apply = "exist";
            return message_apply;
        }
        try {
            if (applyJobModel.getFile() != null) {  //Khi dử dụng CV mới
                Map result = cloudinary.uploader().upload(applyJobModel.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                String image = (String) result.get("secure_url");
                user.setImage(image);
                userService.saveUser(user);
                ApplyPost applyPost1 = new ApplyPost();
                applyPost1.setRecruitment(recruitment);
                applyPost1.setUser(user);
                applyPost1.setText(applyJobModel.getText());
                applyPost1.setLinkCv(image);
                applyPostService.saveApplyPost(applyPost1); //Lưu ApplyPost
                message_apply = "success";

            } else {   //Khi sử dụng CV đã có sẵn trong hệ thống
                CV cv = cvService.findCVByUser(user); //Tìm CV theo User
                if (cv == null) {
                    message_apply = "cv not exist";
                    return message_apply;
                } else {
                    ApplyPost applyPost2 = new ApplyPost();
                    applyPost2.setUser(user);
                    applyPost2.setRecruitment(recruitment);
                    applyPost2.setText(applyJobModel.getText());
                    applyPost2.setLinkCv(cv.getLinkCV());
                    applyPostService.saveApplyPost(applyPost2); //Lưu ApplyPost
                    message_apply = "success";
                }

            }
        } catch (Exception e) {
            message_apply = "fail";
            e.printStackTrace();
        }
        return message_apply;
    }
    //------Chức năng follow-company-----------------------
    @PostMapping(value = "/follow-company")
    public @ResponseBody
    String followCompany(@RequestParam("idCompany") int idCompany) {

        String message = "";
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
            User user = userService.findUserById(userDetails.getId()); //Get User đang đăng nhập hệ thống
            Company company = companyService.findCompanyById(idCompany);  //Get Company theo Id
            FollowCompany followCompany = new FollowCompany(company, user);
            followCompanyService.saveFollowCompany(followCompany); //Lưu FollowCompany
            message = "success";
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            message = "fail";

        }
        return message;
    }
    //------Chức năng bỏ follow-company-----------------------
    @PostMapping(value = "/unFollow-company")
    public @ResponseBody
    String unFollowCompany(@RequestParam("idCompany") int idCompany) {

        String message = "";
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
            User user = userService.findUserById(userDetails.getId());//Get User đang đăng nhập hệ thống
            Company company = companyService.findCompanyById(idCompany);//Get Company theo Id
            followCompanyService.deleteFollowCompanyByUserAndCompany(user, company); //Xóa FollowCompany
            message = "success";

            return message;
        } catch (Exception e) {
            e.printStackTrace();
            message = "fail";

        }
        return message;
    }

    //-------------Chức năng lưu job
    @PostMapping("/saveJob")
    public @ResponseBody
    String saveJob(@RequestParam("recruitmentId") int idRecruitment) {

        String message = "";
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
            User user = userService.findUserById(userDetails.getId());  //Get User đang đăng nhập hệ thống
            Recruitment recruitment = recruitmentService.findRecruitmentById(idRecruitment);//Get Recruitment theo Id
            SaveJob saveJob = saveJobService.findSaveJobByUserAndRecruitment(user, recruitment); //Get SaveJob theo User và Recruitment
            if (saveJob != null) { //Check điều kiện user đã lưu job này chưa
                message = "exist";
                return message;
            } else {
                SaveJob saveJob1 = new SaveJob(recruitment, user);
                saveJobService.saveSaveJob(saveJob1);
                message = "success";
                return message;
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "fail";

        }
        return message;
    }

    //----------Hiện thị danh sách công việc đã lưu----------------------------
    @GetMapping("/list-saveJob/{pageId}")
    public String listSaveJob(@PathVariable("pageId") int pageId, Model model) {
        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId()); //Get User đang đăng nhập hệ thống

        List<SaveJob> listSaveJob = saveJobService.findSaveJobByUser(pageId -1, total,user); //Lấy danh sách các công việc đã lưu theo User
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("listSaveJob", listSaveJob);
        return "list-saveJob";
    }
    //----------Hiện thị danh sách các công ty đã follow ----------------------------
    @GetMapping("/list-companyFollow/{pageId}")
    public String listCompanyFollow(@PathVariable("pageId") int pageId, Model model) {
        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId());//Get User đang đăng nhập hệ thống
        List<FollowCompany> listFollowCompany = followCompanyService.findFollowCompanyByUser(pageId-1, total, user); //Lấy danh sách các công ty đã follow theo User
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("listFollowCompany", listFollowCompany);
        return "list-companyFollow";
    }
    //----------Hiện thị danh sách các công ty đã ứng tuyển----------------------------
    @GetMapping("/list-applyJob/{pageId}")
    public String listApplyJob(@PathVariable("pageId") int pageId, Model model) {
        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId());//Get User đang đăng nhập hệ thống
        List<ApplyPost> listApplyPost = applyPostService.findApplyPostByUser(pageId -1, total,user);//Lấy danh sách công việc đã ứng tuyển theo User
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("listApplyPost", listApplyPost);
        return "list-applyJob";
    }

    //---------------Xóa một công việc đã lưu----------------------
    @GetMapping("/delete-saveJob/{saveJobId}")
    public RedirectView deleteSaveJob(@PathVariable("saveJobId") int saveJobId, RedirectAttributes redirectAttributes) {
        String message = "success";
        try {
           saveJobService.deleteSaveJob(saveJobId);
           redirectAttributes.addFlashAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RedirectView redirectView = new RedirectView("/UCV/list-saveJob/1", true);

        return redirectView;
    }


}
