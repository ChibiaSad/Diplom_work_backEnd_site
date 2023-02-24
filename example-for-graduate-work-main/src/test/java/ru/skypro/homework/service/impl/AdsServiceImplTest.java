package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.mapper.AdsMapperImpl;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class AdsServiceImplTest {
    @Mock
    private AdsRepository adsRepository;
    @Mock
    private ImageServiceImpl imageService;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private CommentServiceImpl commentService;
    @Mock

    @InjectMocks
    private AdsServiceImpl adsService;

    @Test
    void addAdsToDb() throws IOException {
        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Mockito.when(userService.getDefaultUser()).thenReturn(user);

        Image image = new Image();
        image.setFilePath("D:/images/i");
        image.setId(1);

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        CreateAdsDto createAdsDto1 = new CreateAdsDto();
        createAdsDto1.setTitle("Пирог");
        createAdsDto1.setPrice(125);
        createAdsDto1.setDescription("Вкусный пирог");


        Mockito.when(adsRepository.save(ads)).thenReturn(ads);

        AdsDto adsDto = new AdsDto(user.getId(), "/image/1", ads.getId(),
                ads.getPrice(), ads.getTitle());

        Path path = Paths.get("D:/images/i/2_2023-02-22.jpg");
        String name = "2_2023-02-22.jpg";
        String originalFileName = "2_2023-02-22.jpg";
        String contentType = "jpeg";
        byte[] content = Files.readAllBytes(path);

        MultipartFile image1 = new MockMultipartFile(name, originalFileName, contentType, content);

        Mockito.when(imageService.createImage(ads, image1)).thenReturn(image);

        assertThat(adsService.addAdsToDb(createAdsDto1, image1)).isNotNull().isEqualTo(adsDto);
    }

    @Test
    void getAllAds() {


        List<Ads> listAds = new ArrayList<>();

        Image image = new Image();
        image.setFilePath("D:/images/i");
        image.setId(0);

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setImage(image);

        image.setId(1);

        Ads ads1 = new Ads();
        ads1.setId(1);
        ads1.setTitle("Торт");
        ads1.setPrice(135);
        ads1.setDescription("Вкусный торт");
        ads1.setImage(image);

        image.setId(2);

        Ads ads2 = new Ads();
        ads2.setId(2);
        ads2.setTitle("Пироженка");
        ads2.setPrice(85);
        ads2.setDescription("Просто вкусный подукт");
        ads2.setImage(image);

        listAds.add(ads);
        listAds.add(ads1);
        listAds.add(ads2);

        List<AdsDto> listDto = listAds.stream().map(AdsMapper.INSTANCE::adsToAdsDto).
                collect(Collectors.toList());
        ResponseWrapperAdsDto response = new ResponseWrapperAdsDto();
        response.setCount(listDto.size());
        response.setResults(listDto);

        Mockito.when(adsRepository.findAll()).thenReturn(listAds);

        assertThat(adsService.getAllAds()).isNotNull().isEqualTo(response);
    }

    @Test
    void deleteAds() {
        Integer adsPk = 123;

        commentService.deleteAllAdsComment(adsPk);

        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(commentService).deleteAllAdsComment(argumentCaptor.capture());
        Integer actual = argumentCaptor.getValue();

        assertThat(actual).isEqualTo(adsPk);

        imageService.deleteAdsImage(adsPk);
        Mockito.verify(commentService).deleteAllAdsComment(argumentCaptor.capture());
        actual = argumentCaptor.getValue();

        assertThat(actual).isEqualTo(adsPk);

        adsRepository.deleteById(adsPk);
        Mockito.verify(commentService).deleteAllAdsComment(argumentCaptor.capture());
        actual = argumentCaptor.getValue();

        assertThat(actual).isEqualTo(adsPk);
    }

    @Test
    void getAds() {

        Integer adsPk = 0;

        User user = new User();
        user.setId(1);
        user.setEmail("primer@gmail.com");
        user.setPhone("+79991112233");
        user.setFirstName("Иван");
        user.setLastName("Иванов");

        Image image = new Image();
        image.setFilePath("D:/images/i");
        image.setId(0);

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setImage(image);
        ads.setUser(user);

        FullAdsDto adsDto = new FullAdsDto();
        adsDto.setAuthorFirstName("Иван");
        adsDto.setAuthorLastName("Иванов");
        adsDto.setDescription("Вкусный пирог");
        adsDto.setEmail("primer@gmail.com");
        adsDto.setImage("/image/" + ads.getId());
        adsDto.setPhone("+79991112233");
        adsDto.setPk(0);
        adsDto.setPrice(125);
        adsDto.setTitle("Пирог");


        Mockito.when(adsRepository.findById(adsPk)).thenReturn(Optional.of(ads));
        assertThat(adsService.getAds(adsPk)).isNotNull().isEqualTo(adsDto);
    }

    @Test
    void updateAds() {

        Integer adsPk = 0;

        CreateAdsDto createAdsDto1 = new CreateAdsDto();
        createAdsDto1.setTitle("Пирог");
        createAdsDto1.setPrice(125);
        createAdsDto1.setDescription("Вкусный пирог");

        User user = new User();
        user.setId(1);
        user.setEmail("primer@gmail.com");
        user.setPhone("+79991112233");
        user.setFirstName("Иван");
        user.setLastName("Иванов");

        Image image = new Image();
        image.setFilePath("D:/images/i");
        image.setId(0);

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setImage(image);
        ads.setUser(user);

        AdsDto adsDto = new AdsDto(user.getId(), "/image/" + ads.getId(), ads.getId(),
                ads.getPrice(), ads.getTitle());

        Mockito.when(adsRepository.findById(adsPk)).thenReturn(Optional.of(ads));
        Mockito.when(adsRepository.save(ads)).thenReturn(ads);

        assertThat(adsService.updateAds(adsPk, createAdsDto1)).
                isEqualTo(adsDto);
    }

    @Test
    void getAdsMe() {

        User user = new User();
        user.setId(1);
        user.setEmail("primer@gmail.com");
        user.setPhone("+79991112233");
        user.setFirstName("Иван");
        user.setLastName("Иванов");

        Image image = new Image();
        image.setFilePath("D:/images/i");
        image.setId(0);

        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setEmail("primer@gmail.com");
        userDto.setPhone("+79991112233");
        userDto.setFirstName("Иван");
        userDto.setLastName("Иванов");
        userDto.setImage("D:/images/i");

        List<Ads> listAds = new ArrayList<>();

        Ads ads = new Ads();
        ads.setId(0);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setImage(image);

        image.setId(1);

        Ads ads1 = new Ads();
        ads1.setId(1);
        ads1.setTitle("Торт");
        ads1.setPrice(135);
        ads1.setDescription("Вкусный торт");
        ads1.setImage(image);

        image.setId(2);

        Ads ads2 = new Ads();
        ads2.setId(2);
        ads2.setTitle("Пироженка");
        ads2.setPrice(85);
        ads2.setDescription("Просто вкусный подукт");
        ads2.setImage(image);

        listAds.add(ads);
        listAds.add(ads1);
        listAds.add(ads2);

        Mockito.when(userService.getUser()).thenReturn(userDto);
        Mockito.when(adsRepository.findByAdsAuthorId(user.getId())).
                thenReturn(listAds);

        List<AdsDto> listDto = listAds.stream().map(AdsMapper.INSTANCE::adsToAdsDto).
                collect(Collectors.toList());
        ResponseWrapperAdsDto response = new ResponseWrapperAdsDto();
        response.setCount(listDto.size());
        response.setResults(listDto);

        assertThat(adsService.getAdsMe()).isNotNull().isEqualTo(response);
    }

}