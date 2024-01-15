package springproject.dao;

import springproject.entity.CV;

import springproject.entity.User;

public interface CVDAO {
    public CV findCVById(int id);

    public CV findCVByUser(User user);

    public void saveCV(CV cv);
}
