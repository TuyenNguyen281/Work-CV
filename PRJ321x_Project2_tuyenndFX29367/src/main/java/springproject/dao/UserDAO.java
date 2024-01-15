package springproject.dao;

import springproject.entity.User;

public interface UserDAO {
    public void saveUser(User user);

    public User findUserByEmail(String email);

    public User findUserById(int id);
}
