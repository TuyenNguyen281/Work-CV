package springproject.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.RecruitmentDAO;
import springproject.entity.Category;
import springproject.entity.Company;
import springproject.entity.Recruitment;
import springproject.model.TopRecruitmentModel;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentDAO recruitmentDAO;

    @Override
    @Transactional
    public void saveRecruitment(Recruitment recruitment) {
        recruitmentDAO.saveRecruitment(recruitment);
    }

    @Override
    @Transactional
    public List<Recruitment> listRecruitment(int pageId, int total, Company company) {
        return recruitmentDAO.listRecruitment(pageId, total, company);
    }

    @Override
    @Transactional
    public Recruitment findRecruitmentById(int id) {
        return recruitmentDAO.findRecruitmentById(id);
    }

    @Override
    @Transactional
    public boolean deleteRecruitment(int id) {
     return   recruitmentDAO.deleteRecruitment(id);

    }
    @Override
    @Transactional
    public List<TopRecruitmentModel> listTopRecruitment() {
        return recruitmentDAO.listTopRecruitment();
    }

    @Override
    @Transactional
    public List<Recruitment> findRecruitmentByCategory(int pageId, int total, Category category) {
        return recruitmentDAO.findRecruitmentByCategory(pageId, total, category);
    }

    @Override
    @Transactional
    public List<Recruitment> findRecruitmentByAddress(int pageId, int total, String address) {
        return recruitmentDAO.findRecruitmentByAddress(pageId,total, address);
    }
}
