package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.CategoryDAO;
import springproject.entity.Category;
import springproject.model.TopCategoryModel;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public Category getCategoryByName(String name) {
        return categoryDAO.getCategoryByName(name);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
            categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public List<TopCategoryModel> listTopCategory() {
        return categoryDAO.listTopCategory();
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }
}
