package ru.project.service;

import ru.project.entity.User;

import java.util.List;

public interface UserService {


    public void add(User user);

    public void delete(User user);

    public List<User> getAllUsers();

    public User getUserById(long id);
}
