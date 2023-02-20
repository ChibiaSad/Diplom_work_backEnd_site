package ru.skypro.homework.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@RequiredArgsConstructor
@Entity
@Getter
@Setter

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
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

    @OneToOne
    @JoinColumn(name = "user_image")
    private Avatar avatar;
    @OneToMany(mappedBy = "user")
    private Collection<Ads> adsCollection;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", regDate='" + regDate + '\'' +
                ", city='" + city + '\'' +
                ", avatar=" + avatar +
                ", adsCollection=" + adsCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phone, user.phone) && Objects.equals(regDate, user.regDate) && Objects.equals(city, user.city) && Objects.equals(avatar, user.avatar) && Objects.equals(adsCollection, user.adsCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, phone, regDate, city, avatar, adsCollection);
    }

    @OneToMany(mappedBy = "author")
    private Collection<Comment> comment;

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comment) {
        this.comment = comment;
    }
}
