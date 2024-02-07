package com.msansar.userservice.client;

import com.msansar.userservice.client.dto.WordGroupResponseDto;
import com.msansar.userservice.client.dto.WordGroupUpdateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "wordgroup-service", path = "/v1/wordgroup")
public interface WordGroupClient {

    @GetMapping("/{id}")
    ResponseEntity<WordGroupResponseDto> getById(@PathVariable String id);

    @PutMapping("/update") // bağımsız
    ResponseEntity<WordGroupResponseDto> update(WordGroupUpdateRequestDto updateRequestDto);

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id);
}
