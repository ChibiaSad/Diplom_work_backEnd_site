package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.controller.api.ImageApi;
import ru.skypro.homework.service.impl.ImageServiceImpl;

import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ImageApiController implements ImageApi {
    private final ImageServiceImpl imageService;

//    @Override
//    public ResponseEntity<byte[]> updateImage(Integer id, MultipartFile image) throws IOException {
//        byte[] img = imageService.updateImage(id, image);
//        return ResponseEntity.ok()
//                .contentLength(img.length)
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(img);
//    }

    @Override
    public ResponseEntity<byte[]> readImage(Integer id) throws IOException {
        byte[] img = imageService.getImageById(id);
        return ResponseEntity.ok()
                .contentLength(img.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(img);
    }
}
