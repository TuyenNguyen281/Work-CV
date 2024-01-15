package springproject.service;

import org.springframework.stereotype.Service;
import springproject.entity.CV;
import springproject.entity.User;


public interface CVService {
    public CV findCVById(int id);

    public CV findCVByUser(User user);

    public void saveCV(CV cv);
}
