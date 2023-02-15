package ru.skypro.homework.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "ads")
@RequiredArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ads_id", nullable = false)
    private Long ads_id;

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
        Ads ads = (Ads) o;
        return author == ads.author && pk == ads.pk && price == ads.price && Objects.equals(ads_id, ads.ads_id) && Objects.equals(image, ads.image) && Objects.equals(title, ads.title) && Objects.equals(images, ads.images) && Objects.equals(user, ads.user) && Objects.equals(comments, ads.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ads_id, author, image, pk, price, title, images, user, comments);
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id_ads=" + ads_id +
                ", author=" + author +
                ", image='" + image +
                ", pk=" + pk +
                ", price=" + price +
                ", title='" + title  +
                ", images=" + images +
                ", user=" + user +
                ", comments=" + comments;
    }
}
