package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AvatarNotFoundException;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.AvatarRepository;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByEmail = userRepository.getUserByEmail(username);
        if (userByEmail.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        User user = userByEmail.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));

    }
    private Collection<? extends GrantedAuthority> getAuthority(User user) {
        // т.к. у нас только по одной роли у каждого юзера, пока метод выглядит так
        Collection<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole()));
        return roles;
    }


    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;

    @Value("${avatars.directory}")
    private String avatarDir;

    public User getDefaultUser() {
        log.debug("method getDefaultUser started");
        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");
        return user;
    }

    public void createUser(RegisterReq registerReqDto) {
        log.debug("method createUser started");
        User user = new User();
        user.setEmail(registerReqDto.getUsername());
        user.setPassword(registerReqDto.getPassword());
        user.setFirstName(registerReqDto.getFirstName());
        user.setLastName(registerReqDto.getLastName());
        user.setPhone(registerReqDto.getPhone());
        user.setRole("USER");

        userRepository.save(user);
    }

    public UserDto getUser(Authentication auth) {
        log.debug("method getUser started");
        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    public byte[] getAvatarByUserId(Integer id) throws IOException {
        log.debug("method getAvatarByUserId started");
        Avatar avatar = avatarRepository.findById(id).orElseThrow(AvatarNotFoundException::new);
        Path path = Paths.get(avatar.getFilePath());
        return Files.readAllBytes(path);
    }


    public UserDto updateUser(UserDto userDto, Authentication auth) {
        log.debug("method updateUser started");
        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        if (userDto.getFirstName() != null) {
            user.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null) {
            user.setLastName(userDto.getLastName());
        }
        if (userDto.getPhone() != null) {
            user.setPhone(userDto.getPhone());
        }
        return UserMapper.INSTANCE.userToUserDto(userRepository.save(user));
    }

    public NewPasswordDto setPassword(NewPasswordDto body, Authentication auth) {
        log.debug("method setPassword started");

        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        if (user.getPassword().equals(body.getCurrentPassword())) {
            user.setPassword(body.getNewPassword());
        }
        userRepository.save(user);
        return body;
    }


    public UserDto updateUserImage(MultipartFile file, Authentication auth) throws IOException {
        log.debug("method updateUserImage started");
        byte[] data = file.getBytes();
        String extension = Objects.requireNonNull(
                file.getOriginalFilename()).substring(
                file.getOriginalFilename().indexOf("."));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        if (user.getAvatar() == null) {
            Path path = Paths.get(avatarDir,
                    user.getId() + "_" + LocalDateTime.now().format(format) + extension);
            Files.createDirectories(path.getParent());
            Files.write(path, data);

            Avatar avatar = new Avatar();
            avatar.setUser(user);
            avatar.setFilePath(path.toString());
            avatarRepository.save(avatar);

            user.setAvatar(avatar);
            return UserMapper.INSTANCE.userToUserDto(userRepository.save(user));
        }

        Avatar avatar = avatarRepository.findById(user.getAvatar().getId())
                .orElseThrow(AvatarNotFoundException::new);
        Path path = Paths.get(avatar.getFilePath());
        Files.write(path, data);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    public UserDto getUsersMe(Authentication auth) {
        log.debug("method getUsersMe started");
        return null;
    }


    public Optional<User> userExists(String username) {
        return userRepository.getUserByEmail(username);
    }
}
