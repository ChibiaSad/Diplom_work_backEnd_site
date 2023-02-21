package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;


public interface AdsService {

    AdsDto addAdsToDb(CreateAdsDto createAdsDto, MultipartFile images);

    ResponseWrapperAdsDto getAllAds();

    Void deleteAds(Integer adsPk);

    FullAdsDto getAds(Integer adsPk);

    AdsDto updateAds(int adsPk, CreateAdsDto createAdsDto);

    ResponseWrapperAdsDto getAdsMe(Authentication auth);
}
