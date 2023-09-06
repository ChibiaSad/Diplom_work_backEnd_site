package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;


import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {
    @Test
    public void shouldMapUserToUserDto() {

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

        user.setAvatar(avatar);

        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isEqualTo(user.getId());
        assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(userDto.getPhone()).isEqualTo(user.getPhone());
        assertThat(userDto.getImage()).isEqualTo("/users/me/image/" + avatar.getId());
    }


}
