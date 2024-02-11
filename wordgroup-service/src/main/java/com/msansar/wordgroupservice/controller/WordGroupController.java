package com.msansar.wordgroupservice.controller;

import com.msansar.wordgroupservice.dto.WordGroupResponseDto;
import com.msansar.wordgroupservice.dto.WordGroupSaveRequestDto;
import com.msansar.wordgroupservice.dto.WordGroupUpdateRequestDto;
import com.msansar.wordgroupservice.service.WordGroupService;
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
@RequestMapping("/v1/wordgroup")
public class WordGroupController {
    private final WordGroupService service;

    public WordGroupController(WordGroupService service) {
        this.service = service;
    }

    @PostMapping("/save") // bağımlı. Kaydedildiğinde user'a da ekle
    public ResponseEntity<WordGroupResponseDto> save(@RequestBody WordGroupSaveRequestDto saveRequest){
        return ResponseEntity.ok(service.save(saveRequest));
    }

    @PutMapping("/update") // bağımsız
    public ResponseEntity<WordGroupResponseDto> update(WordGroupUpdateRequestDto updateRequestDto){
        return ResponseEntity.ok(service.update(updateRequestDto));
    }

    @DeleteMapping("/delete/{id}") // bağımlı. silindiğinde user'dan da sil
    public String delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordGroupResponseDto> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/merhaba")
    public String merhaba(){
        return "Merhaba";
    }
}
