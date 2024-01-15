package springproject.service;


import springproject.entity.Category;
import springproject.model.TopCategoryModel;

import java.util.List;


public interface CategoryService {

    public Category getCategoryByName(String name);
    public void saveCategory(Category category);
    public List<TopCategoryModel> listTopCategory();
    public Category getCategoryById(int id);

}
