package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.ApplyPost;
import springproject.entity.Company;
import springproject.entity.FollowCompany;
import springproject.entity.User;

import java.util.List;

@Repository
public class FollowCompanyDAOImpl implements FollowCompanyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveFollowCompany(FollowCompany followCompany) {
       try {
           Session currentSession = sessionFactory.getCurrentSession();
           currentSession.saveOrUpdate(followCompany);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public FollowCompany findFollowCompanyByUserAndCompany(User user, Company company) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<FollowCompany> query = currentSession.createQuery("from FollowCompany where user=: userParam and company=: companyParam", FollowCompany.class);
            query.setParameter("userParam", user);
            query.setParameter("companyParam", company);
            FollowCompany followCompany = query.uniqueResult();
            return followCompany;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteFollowCompanyByUserAndCompany(User user, Company company) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("delete from FollowCompany where user=:userParam and company=: companyParam");
            query.setParameter("userParam", user);
            query.setParameter("companyParam", company);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FollowCompany> findFollowCompanyByUser(int pageId, int total,User user) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<FollowCompany> query = currentSession.createQuery("from FollowCompany where user=: userParam", FollowCompany.class);
            query.setParameter("userParam", user);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<FollowCompany> listFollowCompany = query.getResultList();
            return listFollowCompany;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
