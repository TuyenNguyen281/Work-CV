package springproject.service;

import springproject.entity.Company;
import springproject.entity.FollowCompany;
import springproject.entity.User;

import java.util.List;

public interface FollowCompanyService {

    public void saveFollowCompany(FollowCompany followCompany);
    public FollowCompany findFollowCompanyByUserAndCompany(User user, Company company);
    public void deleteFollowCompanyByUserAndCompany(User user , Company company);
    public List<FollowCompany> findFollowCompanyByUser(int pageId, int total, User user);

}
