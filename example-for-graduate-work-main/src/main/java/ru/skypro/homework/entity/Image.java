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
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Integer id;
    @Column(name = "image_path")
    private String filePath;
    @OneToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(filePath, image.filePath) && Objects.equals(ads, image.ads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, ads);
    }
}
