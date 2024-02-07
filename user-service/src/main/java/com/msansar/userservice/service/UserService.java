package com.msansar.userservice.service;

import com.msansar.userservice.client.WordGroupClient;
import com.msansar.userservice.dto.UserLoginRequestDto;
import com.msansar.userservice.dto.UserResponseDto;
import com.msansar.userservice.dto.UserSaveRequestDto;
import com.msansar.userservice.dto.UserUpdateRequestDto;
import com.msansar.userservice.dto.UserWithoutWordGroupResponseDto;
import com.msansar.userservice.dto.converter.UserDtoConverter;
import com.msansar.userservice.exception.GlobalNotFoundException;
import com.msansar.userservice.model.User;
import com.msansar.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final WordGroupClient wordGroupClient;

    public UserService(UserRepository userRepository,
                       UserDtoConverter userDtoConverter, WordGroupClient wordGroupClient) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.wordGroupClient = wordGroupClient;
    }
    public UserResponseDto save(UserSaveRequestDto request){
        // TODO: Bcrypt'lenmiş password ile save yap.
        User user = userRepository.save(
                new User(request.getUsername(), request.getPassword(), request.getEmail())
        );
        return userDtoConverter.convertUserToUserResponseDto(user);
    }
    public UserResponseDto update(UserUpdateRequestDto updatedRequestDto) {
        User user = getEntityById(updatedRequestDto.getId());
        user.setUsername(updatedRequestDto.getUsername());
        user.setPassword(updatedRequestDto.getPassword());
        user.setEmail(updatedRequestDto.getEmail());
        user.setWordGroupIdList(updatedRequestDto.getWordGroupsId());
        return userDtoConverter.convertUserToUserResponseDto(user);
    }

    public UserResponseDto getById(String id){
        User user = getEntityById(id);
        return userDtoConverter.convertUserToUserResponseDto(user);
    }

    public UserResponseDto getUserAndWordGroups(String userId){
        User user = getEntityById(userId);
        return userDtoConverter.convertUserToUserResponseDto(user);
    }
    public String login(UserLoginRequestDto request){
        // TODO: Daha sonra hallet. burası user bilgilerini döndürecek. FULL DTO
        return "LOGIN SAYFASI";
    }
    public String delete(String id){
        User user = getEntityById(id);
        user.getWordGroupIdList().stream().map(
                wordGroupId -> wordGroupClient.delete(wordGroupId)
        );
        userRepository.delete(user);
        return "Kullanıcı silindi!";
    }







    // TODO: Alttaki Endpointleri sil

    public UserResponseDto getById2(String id){
        User user = getEntityById(id);
        return userDtoConverter.convertUserToUserResponseDto(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }


//    public List<WordGroupResponseDto> findAll(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        List<WordGroup> wordGroups= repository.findAll(firstPageWithTwoElements).toList();
//        return dtoConverter.convertToWordGroupResponseDtoList(wordGroups);
//    }


    protected User getEntityById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new GlobalNotFoundException("Kullanıcı Bulunamadı!")
        );
    }
}
