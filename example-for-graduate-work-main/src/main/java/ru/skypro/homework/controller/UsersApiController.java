package ru.skypro.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.NewPassword;
import ru.skypro.homework.model.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@CrossOrigin(value = "http://localhost:3000")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
        this.objectMapper = objectMapper;
    }


    @Override
    public ResponseEntity<Void> getUser1() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewPassword> setPassword(NewPassword body) {
        String accept = request.getHeader("Accept");
        if(accept != null && accept.contains("application/json")){
            try {
                return new ResponseEntity<>(objectMapper.readValue("{\n  \"newPassword\" : " +
                        "\"newPassword\",\n  \"currentPassword\" : \"currentPassword\"\n}", NewPassword.class),
                        HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<User> updateUser(User body) {
        String accept = request.getHeader("Accept");
        if(accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"" +
                                "lastName\" : \"lastName\",\n  \"image\" : \"image\",\n  \"phone\" : \"phone\",\n  " +
                                "\"city\" : \"city\",\n  \"regDate\" : \"regDate\",\n  \"id\" : 0,\n  \"email\" : \"email\"\n}",
                        User.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<User> updateUserImage(MultipartFile image) {
        String accept = request.getHeader("Accept");
        if(accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"" +
                                "lastName\" : \"lastName\",\n  \"image\" : \"image\",\n  \"phone\" : \"phone\",\n  " +
                                "\"city\" : \"city\",\n  \"regDate\" : \"regDate\",\n  \"id\" : 0,\n  \"email\" : \"email\"\n}",
                        User.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
