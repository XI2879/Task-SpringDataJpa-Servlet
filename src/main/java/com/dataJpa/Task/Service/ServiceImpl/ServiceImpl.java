package com.dataJpa.Task.Service.ServiceImpl;

import com.dataJpa.Task.Dto.UserDto;
import com.dataJpa.Task.Entity.User;
import com.dataJpa.Task.Mapper.UserMapper;
import com.dataJpa.Task.Repository.UserRepositorty;
import com.dataJpa.Task.Service.UserService;
import com.dataJpa.Task.exception.EmailAlreadyExistsException;
import com.dataJpa.Task.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceImpl implements UserService {
    private UserRepositorty userRepository;
    private ModelMapper modelMapper;

//    @Autowired
//    public ServiceImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
    @Autowired
    public ServiceImpl(UserRepositorty userRepositorty) {

        this.userRepository = userRepositorty;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = null;
        userDtos=userRepository.findAll().stream().map(user -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto,User.class);
        //need to check email already exists are not here category
        Optional<User> optionalUser=userRepository.findByCategory(user.getCategory());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Category alreday exists exception");
        }

        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUsers() {
        userRepository.deleteAll();

    }


    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);

        User userfinded = userRepository.findById(user.getId())
                .orElseThrow(()->new ResourceNotFoundException("user","id", user.getId()));
        userfinded.setName(user.getName());
        userfinded.setPrice(user.getPrice());
        userfinded.setCategory(user.getCategory());
        userRepository.save(userfinded);

        return UserMapper.mapToUserDto(userfinded);
    }

    @Override
    public UserDto findById(Long id) {
        User optionalUser = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user","id", id));
        return UserMapper.mapToUserDto(optionalUser);
    }


}
