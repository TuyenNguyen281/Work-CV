package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.Category;
import springproject.entity.Company;
import springproject.entity.Recruitment;

import org.hibernate.query.Query;
import springproject.model.TopRecruitmentModel;

import java.util.List;

@Repository
public class RecruitmentDAOImpl implements RecruitmentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveRecruitment(Recruitment recruitment) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(recruitment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recruitment> listRecruitment(int pageId, int total, Company company) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<Recruitment> query = currentSession.createQuery("from Recruitment where  company=: companyParam", Recruitment.class);
            query.setParameter("companyParam", company);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<Recruitment> recruitmentList = query.getResultList();
            return recruitmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Recruitment findRecruitmentById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Recruitment recruitment = currentSession.get(Recruitment.class, id);
        return recruitment;
    }


    @Override
    public List<Recruitment> findRecruitmentByCategory(int pageId, int total, Category category) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<Recruitment> query = currentSession.createQuery("from Recruitment where  category=: categoryParam", Recruitment.class);
            query.setParameter("categoryParam", category);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<Recruitment> recruitmentList = query.getResultList();
            return recruitmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recruitment> findRecruitmentByAddress(int pageId, int total, String addressParam) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<Recruitment> query = currentSession.createQuery("from Recruitment where  upper(address)=: addressParam", Recruitment.class);
            query.setParameter("addressParam", addressParam.toUpperCase());
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<Recruitment> recruitmentList = query.getResultList();
            return recruitmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean deleteRecruitment(int id) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("delete from Recruitment where id=:recruitmentID");
            query.setParameter("recruitmentID", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TopRecruitmentModel> listTopRecruitment() {
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            String sql = "select new springproject.model.TopRecruitmentModel(recruitment, count(recruitment)) \n" +
                    "from Recruitment recruitment join ApplyPost applyPost \n" +
                    "on recruitment = applyPost.recruitment \n" +
                    "group by recruitment \n" +
                    "order by count(recruitment) desc \n";
            Query<TopRecruitmentModel> query = currentSession.createQuery(sql);
            query.setMaxResults(4);
            List<TopRecruitmentModel> recruitmentList = query.getResultList();
            return recruitmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
