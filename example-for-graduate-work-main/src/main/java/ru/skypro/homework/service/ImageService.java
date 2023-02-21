package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

public interface ImageService {
    byte[] updateImage(Integer adsId, MultipartFile file);

    Image getImageById(Long imageId);
}
