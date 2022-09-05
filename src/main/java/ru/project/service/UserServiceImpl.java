package ru.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.dao.UserDAO;
import ru.project.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void update(User changedUser) {
        userDAO.update(changedUser);
    }
}
