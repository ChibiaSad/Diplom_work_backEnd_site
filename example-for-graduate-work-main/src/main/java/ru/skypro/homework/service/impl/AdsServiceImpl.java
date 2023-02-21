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
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;

    @Override
    public AdsDto addAdsToDb(CreateAdsDto createAdsDto, MultipartFile images) {
        return null;
    }

    @Override
    public ResponseWrapperAdsDto getAllAds() {
        List<AdsDto> list = adsRepository.findAll().stream()
                .map(AdsMapper.INSTANCE::adsToAdsDto)
                .collect(Collectors.toList());
        return AdsMapper.INSTANCE.AdsDtoToWrapperAdsDto(list, list.size());
    }

    @Override
    public Void deleteAds(Integer adsPk) {
        return null;
    }

    @Override
    public FullAdsDto getAds(Integer adsPk) {
        return null;
    }

    @Override
    public AdsDto updateAds(int adsPk, CreateAdsDto createAdsDto) {
        return null;
    }

    @Override
    public ResponseWrapperAdsDto getAdsMe(Authentication auth) {
        return null;
    }
}
