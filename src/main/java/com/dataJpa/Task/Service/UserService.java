package com.dataJpa.Task.Service;

import com.dataJpa.Task.Dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto userDto);
    void deleteUsers();

    UserDto updateUser(UserDto userDto);

    UserDto findById(Long id);
}
