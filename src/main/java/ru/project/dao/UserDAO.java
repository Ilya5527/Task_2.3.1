package ru.project.dao;

import ru.project.entity.User;

import java.util.List;

public interface UserDAO {

    public void add(User user);

    public void delete(User user);

    public List<User> getAllUsers();

    public User getUserById(long id);
}
