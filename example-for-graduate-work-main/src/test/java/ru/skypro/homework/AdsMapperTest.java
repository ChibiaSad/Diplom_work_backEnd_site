package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapperAdsDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.AdsMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AdsMapperTest {
    @Test
    public void shouldMapAdsToAdsDto() {

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(1);
        ads.setImage(new Image());
        ads.setPrice(222);
        ads.setTitle("Title");
        ads.setUser(user);



        AdsDto adsDto = AdsMapper.INSTANCE.adsToAdsDto(ads);

        assertThat(adsDto).isNotNull();
        assertThat(adsDto.getAuthor()).isEqualTo(1);
        assertThat(adsDto.getImage()).isEqualTo("/image/" + null);
        assertThat(adsDto.getPrice()).isEqualTo(222);
        assertThat(adsDto.getTitle()).isEqualTo("Title");

    }

    @Test
    public void shouldMapAdsDtoToWrapperAdsDto(){
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
        response.setResults(listDto);
        response.setCount(listAds.size());

        assertThat(AdsMapper.INSTANCE.AdsDtoToWrapperAdsDto(listDto, listDto.size())).isNotNull().isEqualTo(response);
    }

    @Test
    public void shouldMapCreateAdsDtoToAds(){

        CreateAdsDto createAdsDto1 = new CreateAdsDto();
        createAdsDto1.setTitle("Пирог");
        createAdsDto1.setPrice(125);
        createAdsDto1.setDescription("Вкусный пирог");

        Ads ads = new Ads();
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");

        assertThat(AdsMapper.INSTANCE.CreateAdsDtoToAds(createAdsDto1)).isEqualTo(ads);
    }

    @Test
    public void shouldMapadsToFullAdsDto(){

        Image image = new Image();
        image.setFilePath("D:/images/i");

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);
        ads.setImage(image);

        FullAdsDto fullAdsDto = new FullAdsDto();
        fullAdsDto.setAuthorFirstName(ads.getUser().getFirstName());
        fullAdsDto.setAuthorLastName(ads.getUser().getLastName());
        fullAdsDto.setDescription(ads.getDescription());
        fullAdsDto.setEmail(ads.getUser().getEmail());
        fullAdsDto.setImage("/image/" + null);
        fullAdsDto.setPhone(ads.getUser().getPhone());
        fullAdsDto.setPk(0);
        fullAdsDto.setPrice(ads.getPrice());
        fullAdsDto.setTitle(ads.getTitle());

        assertThat(AdsMapper.INSTANCE.adsToFullAdsDto(ads)).isEqualTo(fullAdsDto);

    }

}