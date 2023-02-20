package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public ResponseEntity<byte[]> getAvatarByUserId(Long id) {
        return null;
    }

    @Override
    public boolean createUser(RegisterReq registerReqDto) {
        return false;
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto createUserDto, Authentication auth) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> getUser(Integer id) {
        return null;
    }

    @Override
    public Optional<User> userExists(String username) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<UserDto> getUsersMe(Authentication auth) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> updateUserImage(MultipartFile avatarFile, Authentication auth) {
        return null;
    }
}
