package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import java.util.List;

@Repository
@Transactional
public interface UserDao {
    List<User> getAllUsers();
    void save(User user);
    User getUserById(Long id);
    void delete(Long id);
}
