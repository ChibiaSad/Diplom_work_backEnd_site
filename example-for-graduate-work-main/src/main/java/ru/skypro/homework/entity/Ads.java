package ru.skypro.homework.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ads")
@RequiredArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ads_id", nullable = false)
    private Long id_ads;

    @Column(name = "ads_author")
    private int author;

    @Column(name = "ads_image")
    private String image;

    @Column(name = "ads_pk")
    private int pk;

    @Column(name = "ads_price")
    private int price;

    @Column(name = "ads_title")
    private String title;
    @OneToMany(mappedBy = "ads")
    private Collection<Image> images;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "ads")
    private Collection<Comment> comments;

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
