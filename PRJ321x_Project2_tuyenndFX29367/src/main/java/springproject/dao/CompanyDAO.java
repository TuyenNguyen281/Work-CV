package springproject.dao;

import springproject.entity.Company;
import springproject.entity.User;
import springproject.model.TopCompanyModel;

import java.util.List;

public interface CompanyDAO {
    public Company findCompanyById(int id);

    public Company findCompanyByUser(User user);

    public void saveCompany(Company company);

    public List<TopCompanyModel> listTopCompany();

    public Company findCompanyByName(String nameCompany);

}
