package com.msansar.wordgroupservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String id;
    private String username;
    private String password;
    private String email;
    private List<String> wordGroupsId;
}
