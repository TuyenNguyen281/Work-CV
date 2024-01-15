package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.SaveJobDAO;
import springproject.entity.Recruitment;
import springproject.entity.SaveJob;
import springproject.entity.User;

import java.util.List;

@Service
public class SaveJobServiceImpl implements SaveJobService{
    @Autowired
    private SaveJobDAO saveJobDAO;

    @Override
    @Transactional
    public void saveSaveJob(SaveJob saveJob) {
        saveJobDAO.saveSaveJob(saveJob);
    }

    @Override
    @Transactional
    public SaveJob findSaveJobByUserAndRecruitment(User user, Recruitment recruitment) {
        return saveJobDAO.findSaveJobByUserAndRecruitment(user,recruitment);
    }

    @Override
    @Transactional
    public void deleteSaveJobByUserAndRecruitment(User user, Recruitment recruitment) {
        saveJobDAO.deleteSaveJobByUserAndRecruitment(user,recruitment);
    }

    @Override
    @Transactional
    public List<SaveJob> findSaveJobByUser(int pageId, int total, User user) {
        return saveJobDAO.findSaveJobByUser( pageId,  total, user);
    }

    @Override
    @Transactional
    public void deleteSaveJob(int id) {
        saveJobDAO.deleteSaveJob(id);
    }
}
