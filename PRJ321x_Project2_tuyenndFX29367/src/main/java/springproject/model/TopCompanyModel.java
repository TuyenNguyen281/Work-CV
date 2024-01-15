package springproject.model;

import springproject.entity.Company;



public class TopCompanyModel {
    private Company company;
    private long rank;



    public TopCompanyModel() {
    }

    public Company getCompany() {
        return company;
    }

    public TopCompanyModel(Company company, long rank) {
        this.company = company;
        this.rank = rank;
    }

    public long getRank() {
        return rank;
    }


}
