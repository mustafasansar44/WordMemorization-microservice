package com.msansar.userservice.controller;

import com.msansar.userservice.dto.UserLoginRequestDto;
import com.msansar.userservice.dto.UserResponseDto;
import com.msansar.userservice.dto.UserSaveRequestDto;
import com.msansar.userservice.dto.UserUpdateRequestDto;
import com.msansar.userservice.dto.UserWithoutWordGroupResponseDto;
import com.msansar.userservice.model.User;
import com.msansar.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto saveRequestDto){
        return ResponseEntity.ok(userService.save(saveRequestDto));
    }

    @PutMapping("/update")
    public UserResponseDto update(@RequestBody UserUpdateRequestDto updateRequestDto){
        return userService.update(updateRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return userService.delete(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDto loginRequestDto){
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/getUserAndWordGroups/{id}")
    public ResponseEntity<UserResponseDto> getUserAndWordGroups(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserAndWordGroups(id));
    }





    @GetMapping("/get/{id}")
    public UserResponseDto getById2(@PathVariable String id){
        return userService.getById2(id);
    }

    @GetMapping("/get/findAll")
    public List<User> getAll(){
        return userService.getUsers();
    }

}