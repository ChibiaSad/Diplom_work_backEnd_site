package ru.skypro.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Data
public class CommentDto {

    @JsonProperty("author")
    private Integer author;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("pk")
    private Integer pk;

    @JsonProperty("text")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto comment = (CommentDto) o;
        return Objects.equals(author, comment.author) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(pk, comment.pk) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, createdAt, pk, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author=" + author +
                ", createdAt='" + createdAt + '\'' +
                ", pk=" + pk +
                ", text='" + text + '\'' +
                '}';
    }
}
