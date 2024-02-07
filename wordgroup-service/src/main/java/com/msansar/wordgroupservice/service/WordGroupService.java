package com.msansar.wordgroupservice.service;

import com.msansar.wordgroupservice.client.UserServiceClient;
import com.msansar.wordgroupservice.client.dto.UserResponseDto;
import com.msansar.wordgroupservice.client.dto.UserUpdateRequestDto;
import com.msansar.wordgroupservice.client.dto.UserWithoutWordGroupResponseDto;
import com.msansar.wordgroupservice.dto.WordGroupResponseDto;
import com.msansar.wordgroupservice.dto.WordGroupSaveRequestDto;
import com.msansar.wordgroupservice.dto.WordGroupUpdateRequestDto;
import com.msansar.wordgroupservice.dto.converter.WordGroupDtoConverter;
import com.msansar.wordgroupservice.exception.GlobalNotFoundException;
import com.msansar.wordgroupservice.model.WordGroup;
import com.msansar.wordgroupservice.repository.WordGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordGroupService {

    private final WordGroupRepository repository;
    private final WordGroupDtoConverter dtoConverter;
    private final UserServiceClient userServiceClient;

    public WordGroupService(WordGroupRepository repository,
                            WordGroupDtoConverter dtoConverter,
                            UserServiceClient userServiceClient) {
        this.repository = repository;
        this.dtoConverter = dtoConverter;
        this.userServiceClient = userServiceClient;
    }
    public WordGroupResponseDto save(WordGroupSaveRequestDto request){
        WordGroup wordGroup = new WordGroup(
                request.getForeignWord(),
                request.getLocalWord(),
                request.getDifficultLevel()
        );
        WordGroup result = repository.save(wordGroup);


        UserResponseDto user = userServiceClient.getById(request.getUserId()).getBody();

        List<String> wordGroupsId = user.getWordGroupResponseDtoList()
                .stream()
                .map(WordGroupResponseDto::getId)
                .collect(Collectors.toList());

        wordGroupsId.add(result.getId());

        UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto(
            user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                wordGroupsId
        );

        userServiceClient.update(userUpdateRequestDto);

        return dtoConverter.convertToWordGroupResponseDto(result);
    }
    public WordGroupResponseDto update(WordGroupUpdateRequestDto request) {
        WordGroup wordGroup = getEntityById(request.getId());
        wordGroup.setForeignWord(request.getForeignWord());
        wordGroup.setLocalWord(request.getLocalWord());
        wordGroup.setActive(request.isActive());
        wordGroup.setDifficultLevel(request.getDifficultLevel());
        WordGroup result = repository.save(wordGroup);
        return dtoConverter.convertToWordGroupResponseDto(result);
    }

    public String delete(String id){
        repository.delete(getEntityById(id));
        return "Kelime Grubu Silindi!";
    }

    public WordGroupResponseDto getById(String id){
        return dtoConverter.convertToWordGroupResponseDto(getEntityById(id));
    }

    protected WordGroup getEntityById(String id){
        return repository.findById(id).orElseThrow(
                () -> new GlobalNotFoundException("Kelime Grubu Bulunamadı!")
        );
    }

}
