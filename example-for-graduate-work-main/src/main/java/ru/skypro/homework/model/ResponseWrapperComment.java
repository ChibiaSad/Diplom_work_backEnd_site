package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResponseWrapperComment {
    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("results")
    @Valid
    private List<Comment> results = null;

    public ResponseWrapperComment count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get count
     *
     * @return count
     **/
    @Schema(description = "")

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ResponseWrapperComment results(List<Comment> results) {
        this.results = results;
        return this;
    }

    public ResponseWrapperComment addResultsItem(Comment resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<Comment>();
        }
        this.results.add(resultsItem);
        return this;
    }

    /**
     * Get results
     *
     * @return results
     **/
    @Schema(description = "")
    @Valid
    public List<Comment> getResults() {
        return results;
    }

    public void setResults(List<Comment> results) {
        this.results = results;
    }

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

