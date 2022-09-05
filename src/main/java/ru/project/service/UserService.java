package ru.project.service;

import ru.project.entity.User;

import java.util.List;

public interface UserService {


    public void add(User user);

    public void delete(long id);

    public List<User> getAllUsers();

    public User getUserById(long id);
}
