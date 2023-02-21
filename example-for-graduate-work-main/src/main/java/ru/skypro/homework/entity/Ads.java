package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "ads")
@RequiredArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ads_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ads_author_id")
    private User user;

    @Column(name = "ads_price")
    private int price;

    @Column(name = "ads_title")
    private String title;

    @OneToOne(mappedBy = "ads")
    private Image image;

    @OneToMany(mappedBy = "ads")
    private List<Comment> comments;

    @Column(name = "description")
    private String description;


    @Override
    public String toString() {
        return "Ads{" + "id=" + id + ", author=" + user + ", price=" + price + ", title='" + title + '\'' + ", images=" + image + ", comments=" + comments + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return price == ads.price && Objects.equals(id, ads.id) && Objects.equals(user, ads.user) && Objects.equals(title, ads.title) && Objects.equals(image, ads.image) && Objects.equals(comments, ads.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, price, title, image, comments);
    }


}
