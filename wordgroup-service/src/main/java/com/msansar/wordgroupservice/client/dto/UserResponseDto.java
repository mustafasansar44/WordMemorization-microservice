package com.msansar.wordgroupservice.client.dto;

import com.msansar.wordgroupservice.dto.WordGroupResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private String password;
    private String email;
    private List<WordGroupResponseDto> wordGroupResponseDtoList;
}
