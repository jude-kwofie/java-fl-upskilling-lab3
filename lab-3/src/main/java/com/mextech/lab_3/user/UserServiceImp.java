package com.mextech.lab_3.user;

import com.mextech.lab_3.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{

    private  final UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream().map(user -> new UserResponseDto(user.getId(),user.getName())).collect(Collectors.toList());

    }

    @Override
    public Optional<User> updateUserById() {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUserById(long userId,User user){
        Optional<User> foundUser = userRepository.findById(userId);
        if(foundUser.isPresent()){
            userRepository.(user);
        }
    }

    @Override
    public void deleteUserById(long userId) {
         userRepository.deleteById(userId);
    }

    @Override
    public void deleteUsers() {
        userRepository.deleteAll();
    }
}
