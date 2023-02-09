package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Data
public class CreateAds {
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
        CreateAds createAds = (CreateAds) o;
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
