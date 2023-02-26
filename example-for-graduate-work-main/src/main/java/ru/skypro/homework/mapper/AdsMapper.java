package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;
import ru.skypro.homework.entity.Ads;

import java.util.List;

@Mapper
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(source = "user.id", target = "author")
//    @Mapping(source = "image.filePath", target = "image")
    @Mapping(expression = "java(\"/image/\" + ads.getImage().getId())", target = "image")
    @Mapping(source = "id", target = "pk")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "title", target = "title")
    AdsDto adsToAdsDto(Ads ads);

    @Mapping(source = "list", target = "results")
    ResponseWrapperAdsDto adsDtoToWrapperAdsDto(List<AdsDto> list, int count);

    Ads createAdsDtoToAds(CreateAdsDto createAdsDto);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "title", source = "title")
//    @Mapping(target = "image", source = "image.filePath")
    @Mapping(expression = "java(\"/image/\" + ads.getImage().getId())", target = "image")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "authorFirstName", source = "user.firstName")
    @Mapping(target = "authorLastName", source = "user.lastName")
    FullAdsDto adsToFullAdsDto(Ads ads);
}

