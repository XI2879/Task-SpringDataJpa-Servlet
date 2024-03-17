package com.dataJpa.Task.Service;

import com.dataJpa.Task.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUsers();

    User updateUser(User user);
}
