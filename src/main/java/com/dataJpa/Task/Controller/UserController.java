package com.dataJpa.Task.Controller;

import com.dataJpa.Task.Entity.User;
import com.dataJpa.Task.Service.UserService;
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
    public ResponseEntity<User> addUser(@RequestBody User user){
         userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(){
        userService.deleteUsers();
        return new ResponseEntity<>("deleted successfully:",HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> userUpdate(@PathVariable("id") Long id,@RequestBody User user){
        user.setId(id);
        User userupdated = userService.updateUser(user);
        return ResponseEntity.ok().body(userupdated);
    }

}
