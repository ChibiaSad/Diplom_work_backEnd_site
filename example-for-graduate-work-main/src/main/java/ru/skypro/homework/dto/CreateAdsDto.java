package ru.skypro.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Data
public class CreateAdsDto {
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Integer price ;
    @JsonProperty("title")
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAdsDto createAds = (CreateAdsDto) o;
        return Objects.equals(description, createAds.description) && Objects.equals(price, createAds.price)
                && Objects.equals(title, createAds.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, title);
    }

    @Override
    public String toString() {
        return "CreateAds{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
