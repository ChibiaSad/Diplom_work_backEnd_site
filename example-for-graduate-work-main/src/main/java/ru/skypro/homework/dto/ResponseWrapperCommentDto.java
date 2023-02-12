package ru.skypro.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ResponseWrapperCommentDto {
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private List<CommentDto> results;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperCommentDto that = (ResponseWrapperCommentDto) o;
        return Objects.equals(count, that.count) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, results);
    }

    @Override
    public String toString() {
        return "ResponseWrapperComment{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}

