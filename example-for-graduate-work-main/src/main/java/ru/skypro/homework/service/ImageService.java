package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

public interface ImageService {
    ResponseEntity<Void> updateImage(Integer adsId, MultipartFile file);

    ResponseEntity<Image> getImageById(Long imageId);
}
