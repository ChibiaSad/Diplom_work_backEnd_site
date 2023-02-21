package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.service.ImageService;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public byte[] updateImage(Integer adsId, MultipartFile file) {
        return null;
    }

    @Override
    public Image getImageById(Long imageId) {
        return null;
    }
}
