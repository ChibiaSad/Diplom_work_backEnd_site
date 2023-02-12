package ru.skypro.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Validated
@Data
public class ResponseWrapperAdsDto {
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    @Valid
    private List<AdsDto> results;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperAdsDto that = (ResponseWrapperAdsDto) o;
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

