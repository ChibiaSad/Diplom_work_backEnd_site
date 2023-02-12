package ru.skypro.homework.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
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
    @Column(name = "user_image")
    private String image;

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


}
