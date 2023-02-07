package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-07T05:20:13.054162161Z[GMT]")


public class FullAds {
    @JsonProperty("authorFirstName")
    private String authorFirstName = null;

    @JsonProperty("authorLastName")
    private String authorLastName = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("image")
    @Valid
    private List<String> image = null;

    @JsonProperty("phone")
    private String phone = null;

    @JsonProperty("pk")
    private Integer pk = null;

    @JsonProperty("price")
    private Integer price = null;

    @JsonProperty("title")
    private String title = null;

    public FullAds authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    /**
     * Get authorFirstName
     *
     * @return authorFirstName
     **/
    @Schema(description = "")

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public FullAds authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    /**
     * Get authorLastName
     *
     * @return authorLastName
     **/
    @Schema(description = "")

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public FullAds description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @Schema(description = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FullAds email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @Schema(description = "")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FullAds image(List<String> image) {
        this.image = image;
        return this;
    }

    public FullAds addImageItem(String imageItem) {
        if (this.image == null) {
            this.image = new ArrayList<String>();
        }
        this.image.add(imageItem);
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    @Schema(description = "")

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public FullAds phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     **/
    @Schema(description = "")

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FullAds pk(Integer pk) {
        this.pk = pk;
        return this;
    }

    /**
     * Get pk
     *
     * @return pk
     **/
    @Schema(description = "")

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public FullAds price(Integer price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     **/
    @Schema(description = "")

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public FullAds title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
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