package com.mextech.lab_3.user;

import com.mextech.lab_3.user.dto.UserRequestDto;
import com.mextech.lab_3.user.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(long userId);

    List<UserResponseDto> getUsers();

    Optional<User> updateUserById();

    void deleteUserById(long userId);

    Optional<User> updateUserById(long userId,User user);

    void deleteUsers();

}
