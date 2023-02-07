package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;

public class User {
    @JsonProperty("email")
    private String email = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("phone")
    private String phone = null;

    @JsonProperty("regDate")
    private String regDate = null;

    @JsonProperty("city")
    private String city = null;

    @JsonProperty("image")
    private String image = null;

    public User email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     * @return email
     **/
    @Schema(description = "")

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     * @return firstName
     **/
    @Schema(description = "")

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public User id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @Schema(description = "")

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     * @return lastName
     **/
    @Schema(description = "")

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     * @return phone
     **/
    @Schema(description = "")

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public User regDate(String regDate) {
        this.regDate = regDate;
        return this;
    }

    /**
     * Get regDate
     * @return regDate
     **/
    @Schema(description = "")

    public String getRegDate() {

        return regDate;
    }

    public void setRegDate(String regDate) {

        this.regDate = regDate;
    }

    public User city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Get city
     * @return city
     **/
    @Schema(description = "")

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public User image(String image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     * @return image
     **/
    @Schema(description = "")

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(id, user.id) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(regDate, user.regDate) &&
                Objects.equals(city, user.city) &&
                Objects.equals(image, user.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, id, lastName, phone, regDate, city, image);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", regDate='" + regDate + '\'' +
                ", city='" + city + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
