package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.controller.api.UsersApi;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.impl.UserServiceImpl;

import java.io.IOException;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class UsersApiController implements UsersApi {
    private final UserServiceImpl userService;

    @Override
    public ResponseEntity<UserDto> getUser(Authentication auth) {
        return ResponseEntity.ok(userService.getUser(auth));
    }

    @Override
    public ResponseEntity<NewPasswordDto> setPassword(NewPasswordDto body, Authentication auth) {
        return ResponseEntity.ok(userService.setPassword(body, auth));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto body) {
        return ResponseEntity.ok(userService.updateUser(body));
    }

    @Override
    public ResponseEntity<UserDto> updateUserImage(MultipartFile image) throws IOException {
        return ResponseEntity.ok(userService.updateUserImage(image));
    }

    @Override
    public ResponseEntity<byte[]> readUserImage(Integer id) throws IOException {
        byte[] img = userService.getAvatarByUserId(id);
        return ResponseEntity.ok()
                .contentLength(img.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(img);
    }
}
