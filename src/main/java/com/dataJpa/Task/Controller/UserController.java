package com.dataJpa.Task.Controller;

import com.dataJpa.Task.Dto.UserDto;
import com.dataJpa.Task.Entity.User;
import com.dataJpa.Task.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid  UserDto userDto){
         UserDto userDto1=userService.saveUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> usersDto = userService.getAllUsers();
        return ResponseEntity.ok().body(usersDto);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto usersDto = userService.findById(id);
        return ResponseEntity.ok().body(usersDto);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(){
        userService.deleteUsers();
        return new ResponseEntity<>("deleted successfully:",HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> userUpdate(@PathVariable("id") Long id,@RequestBody @Valid UserDto userDto){
        userDto.setId(id);
        UserDto userupdated = userService.updateUser(userDto);
        return ResponseEntity.ok().body(userupdated);
    }

}
