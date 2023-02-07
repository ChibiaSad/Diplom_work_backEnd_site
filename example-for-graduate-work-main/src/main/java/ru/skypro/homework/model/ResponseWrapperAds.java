package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated
public class ResponseWrapperAds {
    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("results")
    @Valid
    private List<Ads> results = null;

    public ResponseWrapperAds count(Integer count) {
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

    public ResponseWrapperAds results(List<Ads> results) {
        this.results = results;
        return this;
    }

    public ResponseWrapperAds addResultsItem(Ads resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<Ads>();
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
    public List<Ads> getResults() {
        return results;
    }

    public void setResults(List<Ads> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperAds that = (ResponseWrapperAds) o;
        return Objects.equals(count, that.count) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, results);
    }

    @Override
    public String toString() {
        return "ResponseWrapperAds{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}

