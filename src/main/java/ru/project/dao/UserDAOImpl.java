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
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {

        List<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return userList;
    }

    // доделать
    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        User user = entityManager.find(User.class, (int) id);
        entityManager.detach(user);
        return user;
    }
}
