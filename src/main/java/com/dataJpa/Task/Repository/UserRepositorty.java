package com.dataJpa.Task.Repository;

import com.dataJpa.Task.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositorty extends JpaRepository<User,Long> {
    Optional<User> findByCategory(String email);
}
