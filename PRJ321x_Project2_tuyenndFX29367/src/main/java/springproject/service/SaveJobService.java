package springproject.service;

import springproject.entity.Recruitment;
import springproject.entity.SaveJob;
import springproject.entity.User;

import java.util.List;

public interface SaveJobService {

    public void saveSaveJob(SaveJob saveJob);
    public SaveJob findSaveJobByUserAndRecruitment(User user , Recruitment recruitment);
    public void deleteSaveJobByUserAndRecruitment(User user , Recruitment recruitment);

    public List<SaveJob> findSaveJobByUser(int pageId, int total, User user);

    public void deleteSaveJob(int id);
}
