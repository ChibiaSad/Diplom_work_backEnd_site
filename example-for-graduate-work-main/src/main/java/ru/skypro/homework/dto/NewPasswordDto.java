package ru.skypro.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Data
public class NewPasswordDto {
    @JsonProperty("currentPassword")
    private String currentPassword;
    @JsonProperty("newPassword")
    private String newPassword;

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewPasswordDto newPassword = (NewPasswordDto) o;
        return Objects.equals(this.currentPassword, newPassword.currentPassword) &&
                Objects.equals(this.newPassword, newPassword.newPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currentPassword, newPassword);
    }

    @Override
    public String toString() {
        return "NewPassword{" +
                "currentPassword='" + currentPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
