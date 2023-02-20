package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.service.ImageService;

public class ImageServiceImpl implements ImageService {
    @Override
    public ResponseEntity<Void> updateImage(Integer adsId, MultipartFile file) {
        return null;
    }

    @Override
    public ResponseEntity<Image> getImageById(Long imageId) {
        return null;
    }
}
