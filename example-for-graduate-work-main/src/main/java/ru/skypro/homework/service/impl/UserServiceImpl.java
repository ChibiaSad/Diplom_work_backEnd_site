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
import ru.skypro.homework.service.UserService;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
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

    @Override
    public UserDto getUser() {
        return UserMapper.INSTANCE.userToUserDto(getDefaultUser());
//        return null;
    }

    @Override
    public byte[] getAvatarByUserId(Long id) {
        return null;
    }

    @Override
    public boolean createUser(RegisterReq registerReqDto) {
        return false;
    }

    @Override
    public UserDto updateUser(UserDto createUserDto, Authentication auth) {
        return null;
    }

    @Override
    public Optional<User> userExists(String username) {
        return Optional.empty();
    }

    @Override
    public UserDto getUsersMe(Authentication auth) {
        return null;
    }

    @Override
    public byte[] updateUserImage(MultipartFile avatarFile, Authentication auth) {
        return null;
    }
}
