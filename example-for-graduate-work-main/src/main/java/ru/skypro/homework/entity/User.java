package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_first_name")
    private String firstName;
    @Column(name = "user_last_name")
    private String lastName;
    @Column(name = "user_phone")
    private String phone;
    @Column(name = "user_reg_date")
    private String regDate;
    @Column(name = "user_city")
    private String city;
    @Column(name = "user_image")
    private String image;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;
    @OneToMany(mappedBy = "user")
    private Collection<Ads> adsCollection;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) && Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phone, user.phone) && Objects.equals(regDate, user.regDate) && Objects.equals(city, user.city) && Objects.equals(image, user.image) && Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, email, firstName, lastName, phone, regDate, city, image, avatar);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email  +
                ", firstName='" + firstName  +
                ", lastName='" + lastName  +
                ", phone='" + phone  +
                ", regDate='" + regDate  +
                ", city='" + city  +
                ", image='" + image +
                ", avatar=" + avatar +
                ", adsCollection=" + adsCollection;
    }
}
