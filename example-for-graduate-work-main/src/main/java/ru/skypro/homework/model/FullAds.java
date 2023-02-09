package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Validated
@Data
public class FullAds {
    @JsonProperty("authorFirstName")
    private String authorFirstName;
    @JsonProperty("authorLastName")
    private String authorLastName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("email")
    private String email;
    @JsonProperty("image")
    @Valid
    private List<String> image;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("pk")
    private Integer pk;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("title")
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullAds fullAds = (FullAds) o;
        return Objects.equals(authorFirstName, fullAds.authorFirstName) &&
                Objects.equals(authorLastName, fullAds.authorLastName) &&
                Objects.equals(description, fullAds.description) &&
                Objects.equals(email, fullAds.email) &&
                Objects.equals(image, fullAds.image) &&
                Objects.equals(phone, fullAds.phone) &&
                Objects.equals(pk, fullAds.pk) &&
                Objects.equals(price, fullAds.price) &&
                Objects.equals(title, fullAds.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorFirstName, authorLastName, description, email, image, phone, pk, price, title);
    }

    @Override
    public String toString() {
        return "FullAds{" +
                "authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", image=" + image +
                ", phone='" + phone + '\'' +
                ", pk=" + pk +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}