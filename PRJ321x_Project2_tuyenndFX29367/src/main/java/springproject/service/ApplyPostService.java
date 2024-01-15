package springproject.service;

import springproject.entity.ApplyPost;
import springproject.entity.Recruitment;
import springproject.entity.User;

import java.util.List;

public interface ApplyPostService {
    public void saveApplyPost(ApplyPost applyPost);

    public ApplyPost findApplyPostByUserAndRecruitment(User user, Recruitment recruitment);

    public List<ApplyPost> findApplyPostByUser(int pageId, int total, User user);

    public List<ApplyPost> findApplyPostByRecruitment(int pageId, int total, Recruitment recruitment);

    public void updateStatusApplyPost(int applyPostId, int status);

}
