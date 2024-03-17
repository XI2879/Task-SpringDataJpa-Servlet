package com.dataJpa.Task.Repository;

import com.dataJpa.Task.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositorty extends JpaRepository<User,Long> {
}
