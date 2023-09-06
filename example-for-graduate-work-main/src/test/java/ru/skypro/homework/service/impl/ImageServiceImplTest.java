package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {

    @Value("${images.directory}")
    private String imageDir;
    @Mock
    private ImageRepository imageRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ImageServiceImpl imageService;

    @Test
    void createImage() throws IOException {

        Path path1 = Paths.get("src/test/java/ru/skypro/homework/resources/2_2023-02-22.jpg");
        String name = "2_2023-02-22.jpg";
        String originalFileName = "2_2023-02-22.jpg";
        String contentType = "jpeg";
        byte[] content = Files.readAllBytes(path1);

        MultipartFile image1 = new MockMultipartFile(name, originalFileName, contentType, content);

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        String extension = Objects.requireNonNull(
                image1.getOriginalFilename()).substring(
                image1.getOriginalFilename().indexOf("."));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Path path = Paths.get(imageDir,
                ads.getId() + "_" + LocalDateTime.now().format(format) + extension);

        Image image = new Image();
        image.setFilePath(path.toString());
        image.setAds(ads);

        Mockito.when(imageRepository.save(image)).thenReturn(image);

        assertThat(imageService.createImage(ads, image1)).isNotNull().isEqualTo(image);
    }

    @Test
    void updateImage() throws IOException {
        Path path1 = Paths.get("src/test/java/ru/skypro/homework/resources/2_2023-02-22.jpg");
        String name = "2_2023-02-22.jpg";
        String originalFileName = "2_2023-02-22.jpg";
        String contentType = "jpeg";
        byte[] content = Files.readAllBytes(path1);

        MultipartFile image1 = new MockMultipartFile(name, originalFileName, contentType, content);

        Authentication auth = Mockito.mock(Authentication.class);

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        Integer id = ads.getId();

        String extension = Objects.requireNonNull(
                image1.getOriginalFilename()).substring(
                image1.getOriginalFilename().indexOf("."));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Path path = Paths.get(imageDir,
                ads.getId() + "_" + LocalDateTime.now().format(format) + extension);

        Image image = new Image();
        image.setFilePath(path.toString());
        image.setAds(ads);

        Mockito.when(imageRepository.findByAdsId(id)).thenReturn(Optional.of(image));
        Mockito.when(userRepository.getRoleByEmail(auth.getName())).thenReturn(Optional.of("ADMIN"));

        assertThat(imageService.updateImage(id, image1, auth)).isEqualTo(content);
    }

    @Test
    void getImageById() throws IOException {
        Path path1 = Paths.get("src/test/java/ru/skypro/homework/resources/2_2023-02-22.jpg");

        byte[] content = Files.readAllBytes(path1);

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        Integer id = ads.getId();

        Image image = new Image();
        image.setFilePath(path1.toString());
        image.setAds(ads);

        Mockito.when(imageRepository.findById(id)).thenReturn(Optional.of(image));

        assertThat(imageService.getImageById(id)).isEqualTo(content);
    }

    @Test
    void deleteAdsImage() {
        Integer adsPk = 123;

        imageService.deleteAdsImage(adsPk);

        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        verify(imageRepository).deleteByAdsId(argumentCaptor.capture());

        Integer actual = argumentCaptor.getValue();

        assertThat(actual).isEqualTo(adsPk);
    }
}