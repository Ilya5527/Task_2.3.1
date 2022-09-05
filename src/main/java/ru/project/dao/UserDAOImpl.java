package ru.project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.project.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Override

    public List<User> getAllUsers() {

        List<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return userList;
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
