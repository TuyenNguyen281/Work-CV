package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.ApplyPostDAO;
import springproject.entity.ApplyPost;
import springproject.entity.Recruitment;
import springproject.entity.User;

import java.util.List;

@Service
public class ApplyPostServiceImpl implements ApplyPostService {

    @Autowired
    private ApplyPostDAO applyPostDAO;

    @Override
    @Transactional
    public void saveApplyPost(ApplyPost applyPost) {
        applyPostDAO.saveApplyPost(applyPost);
    }

    @Override
    @Transactional
    public ApplyPost findApplyPostByUserAndRecruitment(User user, Recruitment recruitment) {
        return applyPostDAO.findApplyPostByUserAndRecruitment(user, recruitment);
    }

    @Override
    @Transactional
    public List<ApplyPost> findApplyPostByUser(int pageId, int total, User user) {
        return applyPostDAO.findApplyPostByUser(pageId, total, user);
    }

    @Override
    @Transactional
    public List<ApplyPost> findApplyPostByRecruitment(int pageId, int total, Recruitment recruitment) {
        return applyPostDAO.findApplyPostByRecruitment(pageId, total, recruitment);
    }

    @Override
    @Transactional
    public void updateStatusApplyPost(int applyPostId, int status) {
        applyPostDAO.updateStatusApplyPost(applyPostId, status);
    }
}
