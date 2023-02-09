package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ResponseWrapperComment {
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private List<Comment> results;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperComment that = (ResponseWrapperComment) o;
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

