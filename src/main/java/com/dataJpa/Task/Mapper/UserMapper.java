package com.dataJpa.Task.Mapper;

import com.dataJpa.Task.Dto.UserDto;
import com.dataJpa.Task.Entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
//        userDto.setPrice(user.getPrice());
        userDto.setCategory(user.getCategory());
        return userDto;
    }
    public static User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
//        user.setPrice(userDto.getPrice());
        user.setCategory(userDto.getCategory());
        return user;
    }

}
