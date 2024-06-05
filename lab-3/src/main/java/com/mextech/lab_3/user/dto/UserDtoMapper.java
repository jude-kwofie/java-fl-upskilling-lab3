package com.mextech.lab_3.user.dto;

import com.mextech.lab_3.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoMapper  implements Function<User,UserResponseDto> {

    @Override
    public UserResponseDto apply(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName()
        );
    }
}
