package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {
    @Test
    public void shouldMapUserToUserDto() {
        User user = new User();
        user.setId(7);
        user.setEmail("user@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPhone("89077777777");
        user.setRegDate("15/02/2023");
        user.setCity("City");
        user.setImage("image.png");

        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isEqualTo(7);
        assertThat(userDto.getEmail()).isEqualTo("user@gmail.com");
        assertThat(userDto.getFirstName()).isEqualTo("Ivan");
        assertThat(userDto.getLastName()).isEqualTo("Ivanov");
        assertThat(userDto.getPhone()).isEqualTo("89077777777");
        assertThat(userDto.getRegDate()).isEqualTo("15/02/2023");
        assertThat(userDto.getCity()).isEqualTo("City");
        assertThat(userDto.getImage()).isEqualTo("image.png");
    }

    @Test
    public void shouldMapUserDtoToUser() {
        UserDto userDto = new UserDto();
        userDto.setId(7);
        userDto.setEmail("user@gmail.com");
        userDto.setFirstName("Ivan");
        userDto.setLastName("Ivanov");
        userDto.setPhone("89077777777");
        userDto.setRegDate("15/02/2023");
        userDto.setCity("City");
        userDto.setImage("image.png");

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(7);
        assertThat(user.getEmail()).isEqualTo("user@gmail.com");
        assertThat(user.getFirstName()).isEqualTo("Ivan");
        assertThat(user.getLastName()).isEqualTo("Ivanov");
        assertThat(user.getPhone()).isEqualTo("89077777777");
        assertThat(user.getRegDate()).isEqualTo("15/02/2023");
        assertThat(user.getCity()).isEqualTo("City");
        assertThat(user.getImage()).isEqualTo("image.png");
    }
}
