package com.msansar.wordgroupservice.client;

import com.msansar.wordgroupservice.client.dto.UserResponseDto;
import com.msansar.wordgroupservice.client.dto.UserSaveRequestDto;
import com.msansar.wordgroupservice.client.dto.UserUpdateRequestDto;
import com.msansar.wordgroupservice.client.dto.UserWithoutWordGroupResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", path = "/v1/user")
public interface UserServiceClient {

    @PostMapping("/save")
    ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto saveRequestDto);

    @PutMapping("/update")
    UserResponseDto update(@RequestBody UserUpdateRequestDto updateRequestDto);

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDto> getById(@PathVariable String id);
}