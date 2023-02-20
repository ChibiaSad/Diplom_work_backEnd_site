package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;
import ru.skypro.homework.service.AdsService;

import java.util.List;

public class AdsServiceImpl implements AdsService {
    @Override
    public ResponseEntity<AdsDto> addAdsToDb(CreateAdsDto createAdsDto, List<MultipartFile> images, Authentication authentication) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapperAdsDto> getAllAds() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAds(Integer adsPk) {
        return null;
    }

    @Override
    public ResponseEntity<FullAdsDto> getAds(Integer adsPk) {
        return null;
    }

    @Override
    public ResponseEntity<AdsDto> updateAds(int adsPk, CreateAdsDto createAdsDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapperAdsDto> getAdsMe(Authentication auth) {
        return null;
    }
}
