package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdsNotFoundException;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdsServiceImpl {
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final ImageServiceImpl imageService;
    private final CommentServiceImpl commentService;
    private final UserServiceImpl userService;

    public AdsDto addAdsToDb(CreateAdsDto createAdsDto, MultipartFile images,
                             Authentication auth) throws IOException {
        log.debug("method addAdsToDb started");
        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        Ads ads = AdsMapper.INSTANCE.createAdsDtoToAds(createAdsDto);
        ads.setUser(user);
        ads = adsRepository.save(ads);
        ads.setImage(imageService.createImage(ads, images));
        return AdsMapper.INSTANCE.adsToAdsDto(ads);
    }

    public ResponseWrapperAdsDto getAllAds() {
        log.debug("method getAllAds started");
        List<AdsDto> list = adsRepository.findAll().stream()
                .map(AdsMapper.INSTANCE::adsToAdsDto)
                .collect(Collectors.toList());
        return AdsMapper.INSTANCE.adsDtoToWrapperAdsDto(list, list.size());
    }

    public void deleteAds(Integer adsPk, Authentication auth) {
        log.debug("method deleteAds started");
        Ads toDelete = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        if(userService.checkPermission(auth, toDelete.getUser().getEmail())){
            commentService.deleteAllAdsComment(adsPk);
            imageService.deleteAdsImage(adsPk);
            adsRepository.deleteById(adsPk);
        }
    }

    public FullAdsDto getAds(Integer adsPk) {
        log.debug("method getAds started");
        Ads ads = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        return AdsMapper.INSTANCE.adsToFullAdsDto(ads);
    }

    public AdsDto updateAds(int adsPk, CreateAdsDto createAdsDto, Authentication auth) {
        log.debug("method updateAds started");
        Ads ads = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        if(userService.checkPermission(auth, ads.getUser().getEmail())){
            if (createAdsDto.getDescription() != null) {
                ads.setDescription(createAdsDto.getDescription());
            }
            if (createAdsDto.getPrice() != null) {
                ads.setPrice(createAdsDto.getPrice());
            }
            if (createAdsDto.getTitle() != null) {
                ads.setTitle(createAdsDto.getTitle());
            }
        }
        return AdsMapper.INSTANCE.adsToAdsDto(adsRepository.save(ads));
    }

    public ResponseWrapperAdsDto getAdsMe(Authentication auth) {
        log.debug("method getAdsMe started");
        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow();
        List<AdsDto> list = adsRepository.findByAdsAuthorId(user.getId()).stream()
                .map(AdsMapper.INSTANCE::adsToAdsDto)
                .collect(Collectors.toList());
        return AdsMapper.INSTANCE.adsDtoToWrapperAdsDto(list, list.size());
    }

    //Поиск объявлений по полному названию или части названия
    public ResponseWrapperAdsDto findAdsByTitle (String title){
        log.debug("method findAdsByTitle started");
        List<AdsDto> list = adsRepository.findAdsByTitleContainingIgnoreCase(title).stream().
                map(AdsMapper.INSTANCE::adsToAdsDto)
                .collect(Collectors.toList());
        return AdsMapper.INSTANCE.adsDtoToWrapperAdsDto(list, list.size());
    }
}
