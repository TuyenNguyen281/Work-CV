package springproject.model;

import springproject.entity.Category;
import springproject.entity.Company;

public class TopCategoryModel {

    private Category category;
    private long rank;

    public TopCategoryModel() {
    }

    public TopCategoryModel(Category category, long rank) {
        this.category = category;
        this.rank = rank;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
}
