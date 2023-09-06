package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "comment")
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "comment_author_id")
    private User author;

    @Column(name = "comment_created_at")
    private String createdAt;


    @Column(name = "comment_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", author=" + author + ", createdAt='" + createdAt + '\'' + ", text='" + text + '\'' + ", ads=" + ads + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(author, comment.author) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(text, comment.text) && Objects.equals(ads, comment.ads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, createdAt, text, ads);
    }
}
