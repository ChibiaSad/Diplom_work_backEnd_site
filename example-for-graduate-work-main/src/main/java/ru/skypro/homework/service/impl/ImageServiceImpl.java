package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.exception.ImageNotFoundException;
import ru.skypro.homework.repository.ImageRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageServiceImpl{
    @Value("${images.directory}")
    private String imageDir;
    private final ImageRepository imageRepository;


    public Image createImage(Ads ads, MultipartFile file) throws IOException {
        log.debug("method createImage started");
        byte[] data = file.getBytes();
        String extension = Objects.requireNonNull(
                file.getOriginalFilename()).substring(
                        file.getOriginalFilename().indexOf("."));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Path path = Paths.get(imageDir,
                ads.getId() + "_" + LocalDateTime.now().format(format) + extension);
        Files.createDirectories(path.getParent());
        Files.write(path, data);
        Image image = new Image();
        image.setFilePath(path.toString());
        image.setAds(ads);
        return imageRepository.save(image);
    }

    public byte[] updateImage(Integer id, MultipartFile file) throws IOException {
        log.debug("method updateImage started");
        Image img = imageRepository.findByAdsId(id).orElseThrow(ImageNotFoundException::new);
        Path path = Paths.get(img.getFilePath());
        byte[] data = file.getBytes();
        Files.createDirectories(path.getParent());
        Files.write(path, data);
        return data;
    }

    public byte[] getImageById(Integer imageId) throws IOException {
        log.debug("method getImageById started");
        Image image = imageRepository.findById(imageId).orElseThrow(ImageNotFoundException::new);
        Path path = Paths.get(image.getFilePath());
        return Files.readAllBytes(path);
    }

    public void deleteAdsImage(Integer adsPk) {
        log.debug("method deleteAdsImage started");
        imageRepository.deleteByAdsId(adsPk);
    }
}
