package springproject.service;

import org.springframework.stereotype.Service;
import springproject.entity.User;


public interface UserService {

    public void saveUser(User user);

    public User findUserByEmail(String email);

    public User findUserById(int id);
}
