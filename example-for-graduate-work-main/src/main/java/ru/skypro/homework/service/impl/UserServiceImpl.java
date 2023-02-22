package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl{
    private final UserRepository userRepository;

    public User getDefaultUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("0987654321");
        user.setFirstName("Jack");
        user.setLastName("Black");
        return user;
    }

    public UserDto getUser() {
        return UserMapper.INSTANCE.userToUserDto(getDefaultUser());
//        return null;
    }

    public byte[] getAvatarByUserId(Long id) {
        return null;
    }

    public boolean createUser(RegisterReq registerReqDto) {
        User user = new User();
        user.setEmail(registerReqDto.getUsername());
        user.setFirstName(registerReqDto.getFirstName());
        user.setLastName(registerReqDto.getLastName());
        user.setPhone(registerReqDto.getPhone());
        userRepository.save(user);
        return true;
    }

    public UserDto updateUser(UserDto createUserDto, Authentication auth) {
        return null;
    }

    public Optional<User> userExists(String username) {
        return Optional.empty();
    }

    public UserDto getUsersMe(Authentication auth) {
        return null;
    }

    public byte[] updateUserImage(MultipartFile avatarFile, Authentication auth) {
        return null;
    }
}
