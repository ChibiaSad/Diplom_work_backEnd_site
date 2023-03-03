package ru.skypro.homework.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.io.IOException;

@Validated
@RequestMapping("/ads")
public interface AdsApi {
    @Operation(summary = "addAds", tags = "Объявления",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(
                                    schema = @Schema(implementation = AdsDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<AdsDto> addAds(@RequestPart() CreateAdsDto properties,
                                  @Valid @RequestPart("image") MultipartFile image) throws IOException;


    @Operation(summary = "addComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = CommentDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @PostMapping("/{ad_pk}/comments")
    ResponseEntity<CommentDto> addComments(@PathVariable("ad_pk") Integer adPk,
                                           @Valid @RequestBody CommentDto body);


    @Operation(summary = "deleteComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER", "ADMIN"})
    @DeleteMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<Void> deleteComments(@PathVariable("ad_pk") Integer adPk,
                                        @PathVariable("id") Integer id);


    @Operation(tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseWrapperAdsDto.class)))}
    )
    @GetMapping()
    ResponseEntity<ResponseWrapperAdsDto> getALLAds();


    @Operation(summary = "getFullAd", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = FullAdsDto.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @GetMapping("/{id}")
    ResponseEntity<FullAdsDto> getAds(@PathVariable("id") Integer id);


    @Operation(summary = "getAdsMe", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseWrapperAdsDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @GetMapping("/me")
    ResponseEntity<ResponseWrapperAdsDto> getAdsMeUsingGET(Authentication authentication);


    @Operation(summary = "getComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseWrapperCommentDto.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @GetMapping("/{ad_pk}/comments")
    ResponseEntity<ResponseWrapperCommentDto> getComments(@PathVariable("ad_pk") Integer adPk);



    @Operation(summary = "getComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = CommentDto.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER"})
    @GetMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<CommentDto> getComments(@PathVariable("ad_pk") Integer adPk,
                                           @PathVariable("id") Integer id);


    @Operation(summary = "removeAds", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden")}
    )
    @RolesAllowed({"USER", "ADMIN"})
    @DeleteMapping("/{id}")
    ResponseEntity<Void> removeAds(@PathVariable("id") Integer id);


    @Operation(summary = "updateAds", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = AdsDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{id}")
    ResponseEntity<AdsDto> updateAds(@PathVariable("id") Integer id,
                                     @Valid @RequestBody CreateAdsDto body);


    @Operation(summary = "updateComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = CommentDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<CommentDto> updateComments(@PathVariable("ad_pk") Integer adPk,
                                              @PathVariable("id") Integer id,
                                              @Valid @RequestBody CommentDto body);

    @Operation(summary = "updateAdsImage", tags = "Изображения",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    mediaType = MediaType.IMAGE_JPEG_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = byte[].class)))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping(value = "/{ad_pk}/image", produces = MediaType.IMAGE_JPEG_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity <byte[]> updateImage(@PathVariable("ad_pk") Integer adPk,
                                        @Valid @RequestPart("image") MultipartFile image
                                        ) throws IOException;

}
