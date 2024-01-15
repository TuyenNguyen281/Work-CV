package springproject.service;

import springproject.entity.Category;
import springproject.entity.Company;
import springproject.entity.Recruitment;
import springproject.model.TopRecruitmentModel;

import java.util.List;

public interface RecruitmentService {

    public void saveRecruitment(Recruitment recruitment);
    public List<Recruitment> listRecruitment(int pageId, int total, Company company);
    public Recruitment findRecruitmentById(int id);
    public boolean deleteRecruitment(int id);
    public List<TopRecruitmentModel> listTopRecruitment();
    public List<Recruitment> findRecruitmentByCategory(int pageId, int total, Category category);
    public List<Recruitment> findRecruitmentByAddress(int pageId, int total, String address);

}
