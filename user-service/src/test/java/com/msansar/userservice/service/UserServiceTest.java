package com.msansar.userservice.service;

import com.msansar.userservice.dataFactory.UserTestDataFactory;
import com.msansar.userservice.dto.UserResponseDto;
import com.msansar.userservice.dto.UserSaveRequestDto;
import com.msansar.userservice.dto.UserUpdateRequestDto;
import com.msansar.userservice.dto.converter.UserDtoConverter;
import com.msansar.userservice.exception.GlobalNotFoundException;
import com.msansar.userservice.model.User;
import com.msansar.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


// TODO: AOP ile file'dan alınabilir mi ?
// TODO: TEST METODLARININ ADLARINI DÜZELT
// TODO: Spring ElasticSearch

public class UserServiceTest extends UserTestDataFactory {
//    private UserRepository userRepository;
//    private UserDtoConverter userDtoConverter;
//    // private BCryptPasswordEncoder passwordEncoder;
//    private UserService userService;
//
//    @BeforeEach
//    void setUp(){
//        userRepository = mock(UserRepository.class);
//        userDtoConverter = mock(UserDtoConverter.class);
//        // passwordEncoder = mock(BCryptPasswordEncoder.class);
//
//        userService = new UserService(userRepository, userDtoConverter); // TODO: PasswordEncoder'da gelcek
//
//    }
//
//    @Test
//    @DisplayName("delete() eğer id mevcutsa silmeli ve bir mesaj döndürmeli")
//    public void testDelete_whenIdExists_shouldDeleteUser(){
//        User user = generateUser();
//        String id = user.getId();
//
//        var result = userService.delete(id);
//
//        verify(userRepository, times(1)).deleteById(id);
//        assertEquals("Kullanıcı Silindi!", result);
//    }
//
//    // TODO: Ya ismini değiştir ya da metodda userDto dön
//    @Test
//    @DisplayName("save() Pageable sayısına göre user getirmeli")
//    void testSave_itShouldReturnCreatedUserDto(){
//        User user = generateUser();
//        UserResponseDto userResponseDto = generateUserResponseDto();
//        UserSaveRequestDto saveRequestDto = generateUserSaveRequestDto();
//
//        //when(passwordEncoder.encode(saveRequestDto.getPassword())).thenReturn(saveRequestDto.getPassword());
//        when(userRepository.save(user)).thenReturn(user);
//        when(userDtoConverter.convertToUserResponseDto(user)).thenReturn(userResponseDto);
//
//        var result = userService.save(saveRequestDto);
//        assertEquals(userResponseDto, result);
//
//        //verify(passwordEncoder).encode(saveRequestDto.getPassword());
//        verify(userRepository).save(user);
//        verify(userDtoConverter).convertToUserResponseDto(user);
//    }
//    @Test
//    @DisplayName("save() user kaydedilirse geriye bir mesaj dönmeli")
//    void testSave_whenNewUserIsSaved_ShouldReturnMessage(){
//
//    }
//
//    @Test
//    @DisplayName("save() user zaten kayıtlıysa DublicateUserException throw etmeli")
//    void testSave_WhenDuplicateUserIsSaved_ShouldThrowDuplicateUserException(){
//
//    }
//
//    @Test
//    @DisplayName("update() user güncellenirse geriye bir mesaj dönmeli")
//    void testUpdate_whenUserIdExists_ShouldReturnUserResponseDto(){
//        User user = generateUser();
//        String id = user.getId();
//        User updatedUser = user;
//        UserUpdateRequestDto updateRequestDto = new UserUpdateRequestDto(
//                "newUsername", "newPassword", "newEmail");
//        UserResponseDto responseDto = generateUserResponseDto();
//
//        updatedUser.setUsername(updateRequestDto.getUsername());
//        updatedUser.setPassword(updateRequestDto.getPassword());
//        updatedUser.setEmail(updateRequestDto.getEmail());
//
//        responseDto.setUsername(updateRequestDto.getUsername());
//        responseDto.setPassword(updateRequestDto.getPassword());
//        responseDto.setEmail(updateRequestDto.getEmail());
//
//        when(userRepository.findById(id)).thenReturn(Optional.of(user));
//        when(userRepository.save(user)).thenReturn(updatedUser);
//        when(userDtoConverter.convertToUserResponseDto(user)).thenReturn(responseDto);
//
//        var result = userService.update(user.getId(), updateRequestDto);
//        assertEquals(responseDto, result);
//
//        verify(userRepository).findById(id);
//        verify(userRepository).save(updatedUser);
//        verify(userDtoConverter).convertToUserResponseDto(user);
//    }
//
//    @Test
//    void testUpdate_whenUserIdDoesNotExists_ShouldThrowCustomNotFoundException(){
//        UserUpdateRequestDto updateRequestDto = new UserUpdateRequestDto(
//                "username", "password", "email"
//        );
//        String id = "id";
//
//        when(userRepository.findById(id)).thenReturn(Optional.empty());
//
//        assertThrows(GlobalNotFoundException.class, () ->
//                userService.update(id, updateRequestDto));
//
//        verify(userRepository).findById(id);
//        verifyNoMoreInteractions(userRepository);
//        verifyNoInteractions(userDtoConverter);
//    }
//
//    @Test
//    void testUpdate_whenUserIdExistsButUserNotActive_itShouldUserNotActiveException(){
//
//    }
}
