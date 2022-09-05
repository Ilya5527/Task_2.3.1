package ru.project.dao;

import ru.project.entity.User;

import java.util.List;

public interface UserDAO {

    public void add(User user);

    public void delete(long id);

    public List<User> getAllUsers();

    public User getUserById(long id);
}
