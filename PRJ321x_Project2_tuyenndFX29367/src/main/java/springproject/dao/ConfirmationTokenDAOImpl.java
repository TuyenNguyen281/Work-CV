package springproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.ConfirmationToken;


@Repository
public class ConfirmationTokenDAOImpl implements ConfirmationTokenDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken1) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<ConfirmationToken> query = currentSession.createQuery("from ConfirmationToken where confirmationToken=: confirmationTokenParam ", ConfirmationToken.class);
        query.setParameter("confirmationTokenParam", confirmationToken1);
        ConfirmationToken confirmationToken2 =  query.uniqueResult();
return confirmationToken2;
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        Session  currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(confirmationToken);
    }
}
