package ru.skypro.homework.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author")
    private int author;

    @Column(name = "image")
    private String image;

    @Column(name = "pk")
    private int pk;

    @Column(name = "price")
    private int price;

    @Column(name = "title")
    private String title;

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

}
