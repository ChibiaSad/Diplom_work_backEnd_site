package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.AvatarRepository;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private AvatarRepository avatarRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser() {
        RegisterReq registerReqDto = new RegisterReq();
        registerReqDto.setUsername("primer@mail.ru");
        registerReqDto.setPassword("password");
        registerReqDto.setFirstName("Ivan");
        registerReqDto.setLastName("Ivanov");
        registerReqDto.setPhone("+79991112233");
        registerReqDto.setRole(Role.USER);

        User user = new User();
        user.setEmail(registerReqDto.getUsername());
        user.setPassword(registerReqDto.getPassword());
        user.setFirstName(registerReqDto.getFirstName());
        user.setLastName(registerReqDto.getLastName());
        user.setPhone(registerReqDto.getPhone());

        userService.createUser(registerReqDto);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);

        Mockito.verify(userRepository).save(argumentCaptor.capture());

        User actual = argumentCaptor.getValue();

        assertThat(actual).isEqualTo(user);

    }

    @Test
    void getUser() {

//        User user = new User();
//        user.setId(1);
//        user.setEmail("user@gmail.com");
//        user.setPhone("+78005553535");
//        user.setFirstName("First");
//        user.setLastName("Last");
//
//        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
//
//        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
//
//        assertThat(userService.getUser()).isEqualTo(userDto);
    }

    @Test
    void getAvatarByUserId() throws IOException {

        Integer id = 1;

        Path path1 = Paths.get("src/test/java/ru/skypro/homework/resources/2_2023-02-22.jpg");
        byte[] content = Files.readAllBytes(path1);


        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Avatar avatar = new Avatar();
        avatar.setUser(user);
        avatar.setFilePath("src/test/java/ru/skypro/homework/resources/2_2023-02-22.jpg");
        avatar.setId(1);

        Mockito.when(avatarRepository.findById(id)).thenReturn(Optional.of(avatar));

        assertThat(userService.getAvatarByUserId(user.getId())).isEqualTo(content);
    }

    @Test
    void updateUser() {
//        User user = new User();
//        user.setId(1);
//        user.setEmail("user@gmail.com");
//        user.setPhone("+78005553535");
//        user.setFirstName("First");
//        user.setLastName("Last");
//
//        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
//
//        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//
//        assertThat(userService.updateUser(userDto)).isEqualTo(userDto);

    }

    @Test
    void setPassword() {
//        User user = new User();
//        user.setId(1);
//        user.setEmail("user@gmail.com");
//        user.setPhone("+78005553535");
//        user.setFirstName("First");
//        user.setLastName("Last");
//        user.setPassword("pass1234");
//
//        NewPasswordDto newPasswordDto = new NewPasswordDto();
//        newPasswordDto.setNewPassword("password1");
//        newPasswordDto.setCurrentPassword("password");
//
//        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//
//        assertThat(userService.setPassword(newPasswordDto)).isEqualTo(newPasswordDto);

    }

}