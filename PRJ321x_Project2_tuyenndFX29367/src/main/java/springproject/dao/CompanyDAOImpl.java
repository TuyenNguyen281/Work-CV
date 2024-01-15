package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.Category;
import springproject.entity.Company;

import springproject.entity.User;
import springproject.model.TopCompanyModel;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Company findCompanyById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Company company = currentSession.get(Company.class, id);
        return company;
    }

    @Override
    public Company findCompanyByUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Company> query = currentSession.createQuery("from Company where user=: userParam", Company.class);
        query.setParameter("userParam", user);
        Company company = query.uniqueResult();
        return company;
    }

    @Override
    public void saveCompany(Company company) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(company);
    }

    @Override
    public List<TopCompanyModel> listTopCompany() {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
               String sql = "select new springproject.model.TopCompanyModel(company, count(recruitment.company))  from Company company right join Recruitment recruitment\n" +
                            "on recruitment.company = company \n" +
                            "group by recruitment.company\n" +
                            "order by count(recruitment.company) DESC \n";
            Query<TopCompanyModel> query = currentSession.createQuery(sql);
            query.setMaxResults(3);
            List<TopCompanyModel> topCompanyList = query.getResultList();
            return topCompanyList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Company findCompanyByName(String nameCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Company> query = currentSession.createQuery("from Company where upper(nameCompany)=: nameParam", Company.class);
        query.setParameter("nameParam", nameCompany.toUpperCase());
        Company company = query.uniqueResult();

        return company ;
    }

}
