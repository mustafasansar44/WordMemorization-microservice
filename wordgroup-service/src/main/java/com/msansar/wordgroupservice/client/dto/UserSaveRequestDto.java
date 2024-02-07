package com.msansar.wordgroupservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    private String username;
    private String password;
    private String email;

}
