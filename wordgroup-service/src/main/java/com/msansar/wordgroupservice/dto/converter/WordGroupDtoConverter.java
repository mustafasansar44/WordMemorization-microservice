package com.msansar.wordgroupservice.dto.converter;

import com.msansar.wordgroupservice.dto.WordGroupResponseDto;
import com.msansar.wordgroupservice.model.WordGroup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordGroupDtoConverter {
    public WordGroupResponseDto convertToWordGroupResponseDto(WordGroup wordGroup){
        return new WordGroupResponseDto(
                wordGroup.getId(),
                wordGroup.getCreatedAt(),
                wordGroup.getUpdatedAt(),
                wordGroup.getForeignWord(),
                wordGroup.getLocalWord(),
                wordGroup.isActive(),
                wordGroup.getDifficultLevel()
        );
    }

    public List<WordGroupResponseDto> convertToWordGroupResponseDtoList(List<WordGroup> wordGroups){
        return wordGroups.stream()
                .map(wordGroup -> convertToWordGroupResponseDto(wordGroup))
                .collect(Collectors.toList());
    }
}
