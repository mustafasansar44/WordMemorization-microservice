package com.msansar.userservice.dataFactory;

import com.msansar.userservice.dto.UserResponseDto;
import com.msansar.userservice.dto.UserSaveRequestDto;
import com.msansar.userservice.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserTestDataFactory {
    private final static String id = "id";
    private final static String username = "username";
    private final static String password = "{noop}password";
    private final static String email = "email";
    private static LocalDateTime currentDate = LocalDateTime.now();


    public static User generateUser(){
        return new User(id, currentDate, currentDate, username, password, email);
    }
    public static UserResponseDto generateUserResponseDto(){
        return new UserResponseDto(id, currentDate, currentDate, username, password, email);
    }
    public static UserSaveRequestDto generateUserSaveRequestDto(){
        return new UserSaveRequestDto(username, password, email);
    }
    public static List<User> generateUserList(int initUsersLength){
        return IntStream.range(0, initUsersLength)
                .mapToObj(
                        i -> new User(id+1, currentDate, currentDate, username+i, password+i, email+i)
                ).collect(Collectors.toList());
    }
    public static List<UserResponseDto> generateUserDtoList(int initUserDtosLength){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(int i = 0; i <= initUserDtosLength; i++){
            UserResponseDto user = new UserResponseDto(id+1, currentDate, currentDate, username+1, password+1, email+1);
            userResponseDtos.add(user);
        }
        return userResponseDtos;
    }
}
