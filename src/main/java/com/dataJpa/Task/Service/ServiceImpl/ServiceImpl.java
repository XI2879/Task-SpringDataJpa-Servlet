package com.dataJpa.Task.Service.ServiceImpl;

import com.dataJpa.Task.Entity.User;
import com.dataJpa.Task.Repository.UserRepositorty;
import com.dataJpa.Task.Service.UserService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
@NoArgsConstructor
public class ServiceImpl implements UserService {
    private UserRepositorty userRepository;

    @Autowired
    public ServiceImpl(UserRepositorty userRepositorty) {
        this.userRepository = userRepositorty;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
