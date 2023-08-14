package web.service;

import web.model.User;

import java.util.List;


public interface UserService  {
    List<User> getAllUsers();
    void save(User user);
    User getUserById(Long id);
    void delete(Long id);

    void update(User user);

    void update(Long id, User user);
}

