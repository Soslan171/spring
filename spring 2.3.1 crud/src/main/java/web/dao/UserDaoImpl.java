package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User order by  id",User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getUserById(Long id) {
        User user=entityManager.find(User.class,id);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user=entityManager.find(User.class,id);
        if (user != null) {
            entityManager.remove(user);
        }

    }
}
