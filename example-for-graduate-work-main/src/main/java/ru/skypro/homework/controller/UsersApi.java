package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.NewPassword;
import ru.skypro.homework.model.User;

import javax.validation.Valid;

@Validated
@RequestMapping("/users")
public interface UsersApi {
    @Operation(summary = "getUser", tags = {"Пользователи"}, operationId = "getUser_1",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping("/me")
    ResponseEntity<User> getUser();

    @Operation(summary = "setPassword", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PostMapping("/set_password")
    ResponseEntity<NewPassword> setPassword(@Valid @RequestBody NewPassword body);

    @Operation(summary = "updateUser", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping("/me")
    ResponseEntity<User> updateUser(@Valid @RequestBody User body);

    @Operation(summary = "updateUserImage", description = "UpdateUserImage", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<User> updateUserImage(@Valid @RequestPart MultipartFile image);
}
