package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.NewPassword;
import ru.skypro.homework.model.User;

import javax.validation.Valid;

@Validated
public interface UsersApi {

    @Operation(summary = "getUser", description = "", tags = {"Пользователи"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/users/me",
            method = RequestMethod.GET)
    ResponseEntity<User> getUser1();

    @Operation(summary = "setPassword", description = "", tags = {"Пользователи"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = " /users/set_password",
            produces = {"*/*"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<NewPassword> setPassword(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true,
            schema = @Schema()) @Valid @RequestBody NewPassword body);

    @Operation(summary = "updateUser", description = "", tags = {"Пользователи"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),

            @ApiResponse(responseCode = "204", description = "No content"),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = " /users/me",
            produces = {"*/*"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<User> updateUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true,
            schema = @Schema()) @Valid @RequestBody User body);

    @Operation(summary = "updateUserImage", description = "UpdateUserImage", tags = {"Пользователи"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = " /users/me/image",
            produces = {"*/*"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.PATCH)
    ResponseEntity<User> updateUserImage(@Parameter(description = "file detail") @Valid @RequestBody MultipartFile image);
}
