package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.FollowCompanyDAO;
import springproject.entity.Company;
import springproject.entity.FollowCompany;
import springproject.entity.User;

import java.util.List;

@Service
public class FollowCompanyServiceImpl implements FollowCompanyService {

    @Autowired
    private FollowCompanyDAO followCompanyDAO;
    @Override
    @Transactional
    public void saveFollowCompany(FollowCompany followCompany) {
        followCompanyDAO.saveFollowCompany(followCompany);
    }

    @Override
    @Transactional
    public FollowCompany findFollowCompanyByUserAndCompany(User user, Company company) {
        return followCompanyDAO.findFollowCompanyByUserAndCompany(user,company);
    }

    @Override
    @Transactional
    public void deleteFollowCompanyByUserAndCompany(User user, Company company) {
        followCompanyDAO.deleteFollowCompanyByUserAndCompany(user,company);
    }

    @Override
    @Transactional
    public List<FollowCompany> findFollowCompanyByUser(int pageId, int total, User user) {
        return followCompanyDAO.findFollowCompanyByUser(pageId,total,user);
    }
}
