package springproject.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import springproject.config.userdetail.UserPrinciple;
import springproject.entity.*;

import springproject.service.*;

import java.io.IOException;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/CTY")
public class CTYController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private ApplyPostService applyPostService;

//----------------hiển thị profile user ---------------------------
    @GetMapping("/")
    public String profile(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId());    // Lấy thông tin user đang đăng nhập hệ thống
        Company company = companyService.findCompanyByUser(user);
        if (company == null) {
            model.addAttribute("company", new Company());
        } else {
            model.addAttribute("company", company);
        }
        model.addAttribute("user", user);
        return "profile";
    }
    //-------------------update profile user-----------------------------------------
    @PostMapping("/update-profile")
    public RedirectView updateProfile(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        String update_message_success = "";
        String update_message_fail = "";
        try {
            if (!user.getMultipartFile().isEmpty()) {  //Check file gửi kèm trong thông tin của user có không
                Map result = cloudinary.uploader().upload(user.getMultipartFile().getBytes(), ObjectUtils.asMap("resource_type", "auto")); //Upload file lên Cloudinary
                String image = (String) result.get("secure_url");   //Lấy đường dẫn file do Cloudinary gửi về
                user.setImage(image);
            }
            Role role = roleService.getRoleByName(user.getRole().getRoleName());
            user.setRole(role);
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("update_message_success", update_message_success);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("update_message_fail", update_message_fail);
            e.printStackTrace();
        }

        RedirectView redirectView = new RedirectView("/CTY/", true);
        return redirectView;
    }
    //-----------------------Update thông tin công ty--------------------------------
    @PostMapping("/{userId}/update-company")
    public RedirectView updateCompany(@ModelAttribute("Company") Company company, @PathVariable("userId") int userId, RedirectAttributes redirectAttributes) {
        String updateCompany_message_success = "";
        String updateCompany_message_fail = "";
        try {
            if (!company.getMultipartFile().isEmpty()) { //Check file gửi kèm trong thông tin của Company có không
                Map result = cloudinary.uploader().upload(company.getMultipartFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));//Upload file lên Cloudinary
                String image = (String) result.get("secure_url"); //Lấy đường dẫn file do Cloudinary gửi về
                company.setLogo(image);
            }
            User user = userService.findUserById(userId);
            company.setUser(user);
            companyService.saveCompany(company);
            redirectAttributes.addFlashAttribute("update_message_success", updateCompany_message_success);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("update_message_fail", updateCompany_message_fail);
            e.printStackTrace();
        }

        RedirectView redirectView = new RedirectView("/CTY/", true);
        return redirectView;

    }
    //--------------Hiển thị form tạo bài đăng tuyển mới-----------------------
    @GetMapping("/recruitment")
    public Object recruitmentForm(Model model, RedirectAttributes redirectAttributes) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId()); // Lấy thông tin user đang đăng nhập hệ thống
        Company company = companyService.findCompanyByUser(user);  //Lấy thông tin company theo user
        model.addAttribute("recruitment", new Recruitment());
        model.addAttribute("company", company);

        if (company == null) {
            redirectAttributes.addFlashAttribute("message", "1");
            RedirectView redirectView = new RedirectView("/CTY/", true);
            return redirectView;
        } else {
            return "post-recruitment";
        }

    }
    //-----------------------Tạo bài đăng tuyển mới--------
    @PostMapping("/{companyId}/recruitment/add")
    public RedirectView addRecruitment(@PathVariable("companyId") int companyId, @ModelAttribute("recruitment") Recruitment recruitment, RedirectAttributes redirectAttributes) {
        String postRecruitment_message_success = "";
        String postRecruitment_message_fail = "";
        Company company = companyService.findCompanyById(companyId);//Get Company theo Id
        Category category = categoryService.getCategoryByName(recruitment.getCategory().getName()); //Get Category theo Category name
        if (category == null) {
            categoryService.saveCategory(recruitment.getCategory());
        } else {
            recruitment.setCategory(category);
        }
        try {
            recruitment.setCompany(company);
            recruitmentService.saveRecruitment(recruitment); //Lưu bài đăng tuyển mới
            redirectAttributes.addFlashAttribute("postRecruitment_message_success", postRecruitment_message_success);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("postRecruitment_message_fail", postRecruitment_message_fail);
            e.printStackTrace();
        }
        RedirectView redirectView = new RedirectView("/CTY/recruitment", true);
        return redirectView;
    }

    //-------------------Danh sách bài đăng tuyển mới có phân trang---------------------
    @GetMapping("/list-postRecruitment/{pageId}")
    public String listPostRecruitment(@PathVariable("pageId") int pageId, Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
        User user = userService.findUserById(userDetails.getId());//Lấy thông tin user đang đăng nhập hệ thống (có quyền là ROLE_CTY)
        Company company = companyService.findCompanyByUser(user); //Get Company theo user

        int total = 3; //Số row
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.listRecruitment(pageId - 1, total, company); //Lấy danh sách bài đăng tuyển mới theo Company


        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);

        return "list-postRecruitment";
    }
    //-----------Hiển thị thông chi tiết bài đăng tuyển----------------------
    @GetMapping("/recruitment/detail/{recruitmentId}")
    public String detailRecruitment(@PathVariable("recruitmentId") int recruitmentId, Model model) {
        Recruitment recruitment = recruitmentService.findRecruitmentById(recruitmentId);
        model.addAttribute("recruitment", recruitment);
        return "detail-postRecruitment";
    }
    //--------------Hiển thị form chỉnh sửa bài đăng tuyển-----------------------------
    @GetMapping("/recruitment/editPostForm/{recruitmentId}")
    public String editRecruitment(@PathVariable("recruitmentId") int recruitmentId, Model model) {
        Recruitment recruitment = recruitmentService.findRecruitmentById(recruitmentId);
        model.addAttribute("recruitment", recruitment);

        return "edit-postRecruitment";
    }
    //-------------------Lưu thông tin bài đăng tuyển sau khi chỉnh sửa ------------------------------
    @PostMapping("/recruitment/editPost")
    public RedirectView editPost(@ModelAttribute("recruitment") Recruitment recruitment, RedirectAttributes redirectAttributes) {
        String editRecruitment_message_success = "";
        String editRecruitment_message_fail = "";
        Category category = categoryService.getCategoryByName(recruitment.getCategory().getName()); //Get Category theo Category name
        if (category == null) {
            categoryService.saveCategory(recruitment.getCategory());
        } else {
            recruitment.setCategory(category);
        }
        Company company = companyService.findCompanyById(recruitment.getCompany().getId()); //Get Company theo Id
        recruitment.setCompany(company);
        try {
            recruitmentService.saveRecruitment(recruitment);
            redirectAttributes.addFlashAttribute("editRecruitment_message_success", editRecruitment_message_success);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("editRecruitment_message_fail", editRecruitment_message_fail);
            e.printStackTrace();
        }
        RedirectView redirectView = new RedirectView("/CTY/list-postRecruitment/1", true);
        return redirectView;
    }
    //------------------------Xóa một bài đăng tuyển-----------------------------
    @GetMapping("/recruitment/delete/{recruitmentId}")
    public RedirectView deletePost(@PathVariable("recruitmentId") int recruitmentId, RedirectAttributes redirectAttributes) {
        String deleteRecruitment_message_success = "";
        String deleteRecruitment_message_fail = "";
        if(recruitmentService.deleteRecruitment(recruitmentId)) {
            redirectAttributes.addFlashAttribute("deleteRecruitment_message_success", deleteRecruitment_message_success);
            RedirectView redirectView = new RedirectView("/CTY/list-postRecruitment/1", true);
            return redirectView;
        } else {
            redirectAttributes.addFlashAttribute("deleteRecruitment_message_fail", deleteRecruitment_message_fail);
            RedirectView redirectView = new RedirectView("/CTY/list-postRecruitment/1", true);

            return redirectView;
        }



    }
    //----------------------Lấy danh sách user đã ứng tuyển vào một bài đăng tuyển có phân trang
    @GetMapping("/listUCV/{recruitmentId}/{pageId}")
    public String listUCV(@PathVariable("recruitmentId") int recruitmentId, @PathVariable("pageId") int pageId, Model model) {
        Recruitment recruitment = recruitmentService.findRecruitmentById(recruitmentId); //Get Recruitment theo Id
        int total = 3;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }


        List<ApplyPost> applyPostList = applyPostService.findApplyPostByRecruitment(pageId - 1, total, recruitment); //Lấy danh sách user đã ứng tuyển theo Recruitment
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("applyPostList", applyPostList);
        model.addAttribute("recruitmentId", recruitmentId);


        return "list-UCV";
    }
    //------------Phê duyệt một bài ứng tuyển------------------------------
    @GetMapping("/approveUCV/{applyPostId}")
    public @ResponseBody
    String approveUCV(@PathVariable("applyPostId") int applyPostId) {
        String message = "";
        try {
            applyPostService.updateStatusApplyPost(applyPostId, 1);//Cập nhập lại trạng thái bài ứng tuyển
            message = "success";
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;

    }


}
