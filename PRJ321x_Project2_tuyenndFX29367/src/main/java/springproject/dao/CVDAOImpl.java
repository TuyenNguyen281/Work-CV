package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.CV;

import springproject.entity.Company;
import springproject.entity.User;

@Repository
public class CVDAOImpl implements CVDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public CV findCVById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        CV cv = currentSession.get(CV.class, id);
        return cv;
    }

    @Override
    public CV findCVByUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CV> query = currentSession.createQuery("from CV where user=: userParam", CV.class);
        query.setParameter("userParam", user);
        CV cv = query.uniqueResult();
        return cv;
    }

    @Override
    public void saveCV(CV cv) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(cv);
    }
}
