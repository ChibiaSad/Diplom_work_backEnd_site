package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class Ads {

    @JsonProperty("author")
    private int author;

    @JsonProperty("image")
    private String image;

    @JsonProperty("pk")
    private int pk;

    @JsonProperty("price")
    private int price;

    @JsonProperty("title")
    private String title;

    public Ads(int author, String image, int pk, int price, String title) {
        this.author = author;
        this.image = image;
        this.pk = pk;
        this.price = price;
        this.title = title;
    }

    /**
     * Get Author
     * @return Author
     **/
    @Schema(description = "")

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    /**
     * Get Image
     * @return Image
     **/
    @Schema(description = "")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get Pk
     * @return Pk
     **/
    @Schema(description = "")
    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    /**
     * Get Price
     * @return Price
     **/
    @Schema(description = "")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get Title
     * @return Title
     **/
    @Schema(description = "")
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
        Ads that = (Ads) o;
        return author == that.author && pk == that.pk && price == that.price && Objects.equals(image, that.image) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, image, pk, price, title);
    }

    @Override
    public String toString() {
        return "Announcements{" +
                "author=" + author +
                ", image='" + image + '\'' +
                ", pk=" + pk +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
