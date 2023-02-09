package ru.skypro.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ImageApiController implements ImageApi {
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Override
    public ResponseEntity<List<byte[]>> updateImage(Integer id, MultipartFile image) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<byte[]>>(objectMapper.readValue("[ \"\", \"\" ]", List.class),
                        HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
