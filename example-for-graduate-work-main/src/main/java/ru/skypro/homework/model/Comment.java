package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
public class Comment {

    @JsonProperty("author")
    private Integer author = null;

    @JsonProperty("createdAt")
    private String createdAt = null;

    @JsonProperty("pk")
    private Integer pk = null;

    @JsonProperty("text")
    private String text = null;


    @Schema(description = "")

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Comment createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }


    @Schema(description = "")

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Comment pk(Integer pk) {
        this.pk = pk;
        return this;
    }


    @Schema(description = "")

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Comment text(String text) {
        this.text = text;
        return this;
    }


    @Schema(description = "")

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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
