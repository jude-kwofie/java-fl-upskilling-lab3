package com.mextech.lab_3.user;

import com.mextech.lab_3.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getUsers(){
        return  userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }
    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        return  userService.getUserById(id);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUserById(id);
    }

    @PutMapping("{id}")
    public Optional<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }

}
