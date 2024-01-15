package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.Company;

import springproject.entity.Recruitment;
import springproject.entity.SaveJob;
import springproject.entity.User;

import java.util.List;

@Repository
public class SaveJobDAOImpl implements SaveJobDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveSaveJob(SaveJob saveJob) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(saveJob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SaveJob findSaveJobByUserAndRecruitment(User user, Recruitment recruitment) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<SaveJob> query = currentSession.createQuery("from SaveJob where user=: userParam and recruitment=: recruitmentParam", SaveJob.class);
            query.setParameter("userParam", user);
            query.setParameter("recruitmentParam", recruitment);
            SaveJob saveJob = query.uniqueResult();
            return saveJob;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteSaveJobByUserAndRecruitment(User user, Recruitment recruitment) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("delete from SaveJob where user=:userParam and recruitment=: recruitmentParam");
            query.setParameter("userParam", user);
            query.setParameter("recruitmentParam", recruitment);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SaveJob> findSaveJobByUser(int pageId, int total,User user) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<SaveJob> query = currentSession.createQuery("from SaveJob where user=: userParam", SaveJob.class);
            query.setParameter("userParam", user);
            query.setFirstResult(pageId);
            query.setMaxResults(total);
            List<SaveJob> listSaveJob = query.getResultList();
            return listSaveJob;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteSaveJob(int id) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("delete from SaveJob where id=:saveJobId");
            query.setParameter("saveJobId", id);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
