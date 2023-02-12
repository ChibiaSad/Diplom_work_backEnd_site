package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author")
    private Integer author;

    @Column(name = "id")
    private String createdAt;

    @Column(name = "createdAt")
    private Integer pk;

    @Column(name = "text")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(author, comment.author) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(pk, comment.pk) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, createdAt, pk, text);
    }

}
