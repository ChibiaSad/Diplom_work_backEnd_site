package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;

import java.util.Optional;

public interface UserService {
    byte[] getAvatarByUserId(Long id);

    boolean createUser(RegisterReq registerReqDto);


    UserDto updateUser(UserDto createUserDto, Authentication auth);


    UserDto getUser();

    Optional<User> userExists(String username);

    UserDto getUsersMe(Authentication auth);

    byte[] updateUserImage(MultipartFile avatarFile, Authentication auth);

}
