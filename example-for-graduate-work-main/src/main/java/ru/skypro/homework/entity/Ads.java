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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

//    @Column(name = "ads_image")
//    private String image;

//    @Column(name = "ads_pk")
//    private int pk;

    @Column(name = "ads_price")
    private int price;

    @Column(name = "ads_title")
    private String title;
    @OneToMany(mappedBy = "ads")
    private Collection<Image> images;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(mappedBy = "ads")
    private Collection<Comment> comments;


    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", author=" + author +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", images=" + images +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return price == ads.price && Objects.equals(id, ads.id) && Objects.equals(author, ads.author) && Objects.equals(title, ads.title) && Objects.equals(images, ads.images) && Objects.equals(comments, ads.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, price, title, images, comments);
    }


}
