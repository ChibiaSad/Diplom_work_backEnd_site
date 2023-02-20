package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;

import java.util.Optional;

public interface UserService {
    ResponseEntity<byte[]> getAvatarByUserId(Long id);

    boolean createUser(RegisterReq registerReqDto);


    ResponseEntity<UserDto> updateUser(UserDto createUserDto, Authentication auth);


    ResponseEntity<UserDto> getUser(Integer id);

    Optional<User> userExists(String username);

    ResponseEntity<UserDto> getUsersMe(Authentication auth);

    ResponseEntity<byte[]> updateUserImage(MultipartFile avatarFile, Authentication auth);

}
