package springproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springproject.entity.Category;
import springproject.entity.Company;
import springproject.model.TopCategoryModel;

import java.util.List;


@Repository
public class CategoryDAOImpl implements CategoryDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category getCategoryByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> query = currentSession.createQuery("from Category where upper(name)=: nameParam", Category.class);
        query.setParameter("nameParam", name.toUpperCase());
        Category category = query.uniqueResult();

        return category;
    }

    @Override
    public void saveCategory(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }

    @Override
    public List<TopCategoryModel> listTopCategory() {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            String sql = "select new springproject.model.TopCategoryModel(category, count(recruitment.category)) \n" +
                    "from Recruitment recruitment left join Category category \n" +
                    "on recruitment.category = category \n" +
                    "group by recruitment.category \n" +
                    "order by count(recruitment.category) desc";
            Query<TopCategoryModel> query = currentSession.createQuery(sql);
            query.setMaxResults(4);
            List<TopCategoryModel> topCategoryList = query.getResultList();
            return topCategoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            Category category = currentSession.get(Category.class, id);
            return category;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
