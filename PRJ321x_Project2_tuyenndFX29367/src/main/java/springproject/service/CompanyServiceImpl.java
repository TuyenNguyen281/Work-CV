package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.CompanyDAO;
import springproject.entity.Company;
import springproject.entity.User;
import springproject.model.TopCompanyModel;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional
    public Company findCompanyById(int id) {
        return companyDAO.findCompanyById(id);
    }

    @Override
    @Transactional
    public Company findCompanyByUser(User user) {
        return companyDAO.findCompanyByUser(user);
    }

    @Override
    @Transactional
    public void saveCompany(Company company) {
        companyDAO.saveCompany(company);
    }

    @Override
    @Transactional
    public List<TopCompanyModel> listTopCompany() {
        return companyDAO.listTopCompany();
    }

    @Override
    @Transactional
    public Company findCompanyByName(String nameCompany) {
        return companyDAO.findCompanyByName(nameCompany);
    }


}
