package com.msansar.userservice.dto.converter;


import com.msansar.userservice.client.WordGroupClient;
import com.msansar.userservice.dto.UserResponseDto;
import com.msansar.userservice.dto.UserWithoutWordGroupResponseDto;
import com.msansar.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

//TODO: Java Record Kullan!
@Component
public class UserDtoConverter {
    private final WordGroupClient wordGroupClient;

    public UserDtoConverter(WordGroupClient wordGroupClient) {
        this.wordGroupClient = wordGroupClient;
    }

    public UserResponseDto convertUserToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getWordGroupIdList().stream().map(
                        wordGroupId -> wordGroupClient.getById(wordGroupId).getBody()
                ).collect(Collectors.toList())
        );
    }
    public UserWithoutWordGroupResponseDto convertUserToUserWithoutWordGroupResponseDto(User user){
        return new UserWithoutWordGroupResponseDto(
                user.getId(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }

}
