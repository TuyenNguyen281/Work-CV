package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.Role;
@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleByName(String name) {
        Session  currentSession = sessionFactory.getCurrentSession();
        Query<Role> query = currentSession.createQuery("from Role where roleName=: nameParam", Role.class);
        query.setParameter("nameParam", name);
        Role role = query.uniqueResult();

        return role;
    }

    @Override
    public void saveRole(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(role);


    }
}
