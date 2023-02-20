package ru.skypro.homework.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "avatar")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avatar_id", nullable = false)
    private Long id;
    @Column(name = "avatar_path")
    private String filePath;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return Objects.equals(id, avatar.id) && Objects.equals(filePath, avatar.filePath) && Objects.equals(user, avatar.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, user);
    }
}
