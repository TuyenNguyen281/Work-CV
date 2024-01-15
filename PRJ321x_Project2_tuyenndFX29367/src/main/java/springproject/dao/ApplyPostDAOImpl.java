package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.*;

import java.util.List;

@Repository
public class ApplyPostDAOImpl implements ApplyPostDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveApplyPost(ApplyPost applyPost) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(applyPost);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ApplyPost findApplyPostByUserAndRecruitment(User user, Recruitment recruitment) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<ApplyPost> query = currentSession.createQuery("from ApplyPost where user=: userParam and recruitment=:recruitmentParam", ApplyPost.class);
            query.setParameter("userParam", user);
            query.setParameter("recruitmentParam", recruitment);
            ApplyPost applyPost = query.uniqueResult();
            return applyPost;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ApplyPost> findApplyPostByUser(int pageId, int total, User user) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<ApplyPost> query = currentSession.createQuery("from ApplyPost where user=: userParam ", ApplyPost.class);
            query.setParameter("userParam", user);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<ApplyPost> listApplyPost = query.getResultList();
            return listApplyPost;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ApplyPost> findApplyPostByRecruitment(int pageId, int total, Recruitment recruitment) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<ApplyPost> query = currentSession.createQuery("from ApplyPost where recruitment=: recruitmentParam ", ApplyPost.class);
            query.setParameter("recruitmentParam", recruitment);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<ApplyPost> listApplyPost = query.getResultList();
            return listApplyPost;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStatusApplyPost(int applyPostId, int status) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("update ApplyPost set status =:statusParam where id=:applyPostIdParam");
            query.setParameter("statusParam", status);
            query.setParameter("applyPostIdParam", applyPostId);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
