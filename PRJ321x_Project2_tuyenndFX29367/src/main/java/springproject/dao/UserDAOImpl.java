package springproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springproject.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(user);
    }

    @Override
    public User findUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where email=: emailParam", User.class);
        query.setParameter("emailParam", email);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public User findUserById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user;
    }
}
