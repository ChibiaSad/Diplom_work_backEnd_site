package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;
import ru.skypro.homework.entity.Ads;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "image.filePath", target = "image")
    @Mapping(source = "id", target = "pk")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "title", target = "title")
    AdsDto adsToAdsDto(Ads ads);

//    @InheritInverseConfiguration
//    Ads adsDtoToAds(AdsDto adsDto);

    @Mapping(source = "list", target = "results")
    ResponseWrapperAdsDto AdsDtoToWrapperAdsDto(List<AdsDto> list, int count);
}

