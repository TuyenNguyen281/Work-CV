package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.CVDAO;
import springproject.entity.CV;
import springproject.entity.User;

@Service
public class CVServiceImpl implements CVService{
    @Autowired
    private CVDAO cvdao;

    @Override
    @Transactional
    public CV findCVById(int id) {
        return cvdao.findCVById(id);
    }

    @Override
    @Transactional
    public CV findCVByUser(User user) {
        return cvdao.findCVByUser(user);
    }

    @Override
    @Transactional
    public void saveCV(CV cv) {
        cvdao.saveCV(cv);
    }
}
