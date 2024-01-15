package springproject.dao;


import springproject.entity.Category;
import springproject.model.TopCategoryModel;
import springproject.model.TopCompanyModel;

import java.util.List;

public interface CategoryDAO {
    public Category getCategoryByName(String name);
    public void saveCategory(Category category);
    public List<TopCategoryModel> listTopCategory();
    public Category getCategoryById(int id);



}
