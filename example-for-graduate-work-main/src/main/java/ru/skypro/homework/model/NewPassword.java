package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
public class NewPassword {

    @JsonProperty("currentPassword")
    private String currentPassword = null;

    @JsonProperty("newPassword")
    private String newPassword = null;

    public NewPassword currentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
        return this;
    }

    /**
     * Get currentPassword
     * @return currentPassword
     **/
    @Schema(description = "")

    public String getCurrentPassword() {

        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {

        this.currentPassword = currentPassword;
    }

    public NewPassword newPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    /**
     * Get newPassword
     * @return newPassword
     **/
    @Schema(description = "")

    public String getNewPassword() {

        return newPassword;
    }

    public void setNewPassword(String newPassword) {

        this.newPassword = newPassword;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewPassword newPassword = (NewPassword) o;
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
