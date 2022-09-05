package ru.project.service;

import ru.project.entity.User;

import java.util.List;

public interface UserService {


    void add(User user);

    void delete(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    void update(User changedUser);
}
