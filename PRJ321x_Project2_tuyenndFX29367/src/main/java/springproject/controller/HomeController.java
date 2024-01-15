package springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springproject.config.userdetail.UserPrinciple;
import springproject.entity.*;
import springproject.model.TopCategoryModel;
import springproject.model.TopRecruitmentModel;
import springproject.service.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private FollowCompanyService followCompanyService;

//--------------Hiển thị trang chủ ---------------------------
    @GetMapping("/")
    public String homePage(Model model) {
        List listTopCompany = companyService.listTopCompany();//Danh sách top các Company theo số lượng bài đăng tuyển công ty có
        List<TopRecruitmentModel> listTopRecruitment = recruitmentService.listTopRecruitment(); //Danh sách top các bài đăng tuyển theo số lượng người đã ứng tuyển
        List<TopCategoryModel> listTopCategory = categoryService.listTopCategory();//Danh sách top các Category theo số lượng bài đăng tuyển có

        UserPrinciple userDetails = UserLoggedIn();

        model.addAttribute("userDetails", userDetails);
        model.addAttribute("listTopCompany", listTopCompany);
        model.addAttribute("listTopRecruitment", listTopRecruitment);
        model.addAttribute("listTopCategory", listTopCategory);

        return "home";
    }

    //----------Hiển thị thông tin chi tiết thông tin company------------------------------
    @GetMapping("/detail-company/{companyId}/{pageId}")
    public String detailCompany(@PathVariable("companyId") int companyId, @PathVariable("pageId") int pageId, Model model) {
        Company company = companyService.findCompanyById(companyId); //Get Company theo Id
        UserPrinciple userDetails = UserLoggedIn();//Get UserPrinciple đang đăng nhập hệ thống
        User user = null;
        if (userDetails !=null) {
         user = userService.findUserById(userDetails.getId());//Get thông tin user đang đăng nhập hệ thống
        }
        FollowCompany followCompany = followCompanyService.findFollowCompanyByUserAndCompany(user, company); //Get FollowCompany theo User và Company

        if (followCompany != null) {
            System.out.println("followCompany2:  "+ followCompany);
            model.addAttribute("checkFollow", "followed");
        } else {
            model.addAttribute("checkFollow", "not yet follow");
        }
        int total = 3;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.listRecruitment(pageId - 1, total, company); //Danh sách các bài đăng tuyển của công ty hiên có

        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);
        model.addAttribute("company", company);
        model.addAttribute("userDetails", userDetails);


        return "detail-company";
    }
    //------------Xem thông tin chi tiết một bài đăng tuyển------------
    @GetMapping("/recruitment/detail/{recruitmentId}")
    public String detailRecruitment(@PathVariable("recruitmentId") int recruitmentId, Model model) {
        Recruitment recruitment = recruitmentService.findRecruitmentById(recruitmentId); //Get Recruitment theo Id
        UserPrinciple userDetails = UserLoggedIn();
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("recruitment", recruitment);

        return "detail-postRecruitment";
    }
    //-----------------Danh sách bài đăng tuyển theo Category--------------------
    @GetMapping("/list-job/{categoryId}/{pageId}")
    public String listJob(@PathVariable("categoryId") int categoryId, @PathVariable("pageId") int pageId, Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        UserPrinciple userDetails = UserLoggedIn();

        int total = 3;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.findRecruitmentByCategory(pageId - 1, total, category); //Get danh sách bài đăng tuyển theo Category
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("category", category);

        return "list-job";
    }

    //-------------Chức năng tìm kiếm bài đăng tuyển theo Category-----------------------
    @GetMapping("/recruitment/searchByCategory/{pageId}")
    public String searchByCategory(@RequestParam("keySearch") String categoryName, @PathVariable("pageId") int pageId, Model model) {
        System.out.println(categoryName);
        UserPrinciple userDetails = UserLoggedIn();
        Category category = categoryService.getCategoryByName(categoryName); //Get Category theo Category name
        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.findRecruitmentByCategory(pageId - 1, total, category);//Get danh sách bài đăng tuyển theo Category
        model.addAttribute("keySearch", categoryName);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);
        return "result-searchByCategory";
    }
    //-------------Chức năng tìm kiếm bài đăng tuyển theo Company-----------------------
    @GetMapping("/recruitment/searchByCompany/{pageId}")
    public String searchByCompany(@RequestParam("keySearch") String companyName, @PathVariable("pageId") int pageId, Model model) {
        System.out.println(companyName);
        UserPrinciple userDetails = UserLoggedIn();
        Company company = companyService.findCompanyByName(companyName);//Get Company theo Company name
        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.listRecruitment(pageId - 1, total, company);//Get danh sách bài đăng tuyển theo Company
        model.addAttribute("keySearch", companyName);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);
        return "result-searchByCompany";
    }
    //-------------Chức năng tìm kiếm bài đăng tuyển theo Địa chỉ làm việc-----------------------
    @GetMapping("/recruitment/searchByAddress/{pageId}")
    public String searchByAddress(@RequestParam("keySearch") String address, @PathVariable("pageId") int pageId, Model model) {

        UserPrinciple userDetails = UserLoggedIn();

        int total = 2;
        int numberPage = pageId;
        if (pageId == 1) {
            // do nothing!
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        List<Recruitment> recruitmentList = recruitmentService.findRecruitmentByAddress(pageId - 1, total, address);//Get danh sách bài đăng tuyển theo address

        model.addAttribute("keySearch", address);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("pageNumber", numberPage);
        model.addAttribute("recruitmentList", recruitmentList);
        return "result-searchByAddress";
    }

    //--------------Method get UserPrinciple của user đang đăng nhập hệ thống
    private UserPrinciple UserLoggedIn() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext.getAuthentication().getPrincipal() instanceof UserPrinciple) {
            UserPrinciple userDetails = (UserPrinciple) securityContext.getAuthentication().getPrincipal();
            return userDetails;
        }
        return null;
    }

}
