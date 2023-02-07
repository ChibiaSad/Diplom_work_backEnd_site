package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Validated
public class CreateAds {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("price")
    private Integer price = null;

    @JsonProperty("title")
    private String title = null;

    public CreateAds description(String description) {
        this.description = description;
        return this;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateAds price(Integer price) {
        this.price = price;
        return this;
    }

    @Schema(required = true, description = "")
    @NotNull

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CreateAds title(String title) {
        this.title = title;
        return this;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
