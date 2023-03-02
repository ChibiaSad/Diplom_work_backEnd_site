package ru.skypro.homework.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UserDto;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.io.IOException;

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
    ResponseEntity<UserDto> getUser(Authentication auth);

    @Operation(summary = "setPassword", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )

    @PostMapping("/set_password")
    ResponseEntity<NewPasswordDto> setPassword(@Valid @RequestBody NewPasswordDto body, Authentication auth);

    @Operation(summary = "updateUser", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping("/me")
    ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto body);

    @Operation(summary = "updateUserImage", description = "UpdateUserImage", tags = {"Пользователи"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )

    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<UserDto> updateUserImage(@Valid @RequestPart MultipartFile image) throws IOException;

    @Operation(summary = "readUserImage", tags = "Изображения",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    mediaType = MediaType.IMAGE_JPEG_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = byte[].class)))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping(value = "/me/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    ResponseEntity <byte[]> readUserImage(@PathVariable("id") Integer id) throws IOException;
}
