package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdsNotFoundException;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repository.AdsRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdsServiceImpl {
    private final AdsRepository adsRepository;
    private final ImageServiceImpl imageService;
    private final UserServiceImpl userService;

    public AdsDto addAdsToDb(CreateAdsDto createAdsDto, MultipartFile images) throws IOException {
        User user = userService.getDefaultUser();
        Ads ads = AdsMapper.INSTANCE.CreateAdsDtoToAds(createAdsDto);
        ads.setUser(user);
        ads = adsRepository.save(ads);
        ads.setImage(imageService.createImage(ads, images));
        return AdsMapper.INSTANCE.adsToAdsDto(ads);
    }

    public ResponseWrapperAdsDto getAllAds() {
        List<AdsDto> list = adsRepository.findAll().stream()
                .map(AdsMapper.INSTANCE::adsToAdsDto)
                .collect(Collectors.toList());
        return AdsMapper.INSTANCE.AdsDtoToWrapperAdsDto(list, list.size());
    }

    public Void deleteAds(Integer adsPk) {
        return null;
    }

    public FullAdsDto getAds(Integer adsPk) {
        Ads ads = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        return AdsMapper.INSTANCE.adsToFullAdsDto(ads);
    }

    public AdsDto updateAds(int adsPk, CreateAdsDto createAdsDto) {
        return null;
    }

    public ResponseWrapperAdsDto getAdsMe(Authentication auth) {
        return null;
    }
}
