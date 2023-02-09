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
import ru.skypro.homework.model.*;

import javax.validation.Valid;

@Validated
@RequestMapping("/ads")
public interface AdsApi {
    @Operation(summary = "addAds", tags = "Объявления",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(
                                    schema = @Schema(implementation = Ads.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Ads> addAds(@RequestPart() CreateAds properties,
                               @Valid @RequestPart("image") MultipartFile image);


    @Operation(summary = "addComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = Comment.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PostMapping("/{ad_pk}/comments")
    ResponseEntity<Comment> addComments(@PathVariable("ad_pk") String adPk,
                                        @Valid @RequestBody Comment body);


    @Operation(summary = "deleteComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @DeleteMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<Void> deleteComments(@PathVariable("ad_pk") String adPk,
                                        @PathVariable("id") Integer id);


    @Operation(tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseWrapperAds.class)))}
    )
    @GetMapping()
    ResponseEntity<ResponseWrapperAds> getALLAds();


    @Operation(summary = "getFullAd", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = FullAds.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping("/{id}")
    ResponseEntity<FullAds> getAds(@PathVariable("id") Integer id);


    @Operation(summary = "getAdsMe", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseWrapperAds.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping("/me")
    ResponseEntity<ResponseWrapperAds> getAdsMeUsingGET();


    @Operation(summary = "getComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseWrapperComment.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping("/{ad_pk}/comments")
    ResponseEntity<ResponseWrapperComment> getComments(@PathVariable("ad_pk") String adPk);


    @Operation(summary = "getComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = Comment.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @GetMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<Comment> getComments(@PathVariable("ad_pk") String adPk,
                                        @PathVariable("id") Integer id);


    @Operation(summary = "removeAds", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden")}
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> removeAds(@PathVariable("id") Integer id);


    @Operation(summary = "updateAds", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = Ads.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping("/{id}")
    ResponseEntity<Ads> updateAds(@PathVariable("id") Integer id,
                                  @Valid @RequestBody CreateAds body);


    @Operation(summary = "updateComments", tags = {"Объявления"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = Comment.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping("/{ad_pk}/comments/{id}")
    ResponseEntity<Comment> updateComments(@PathVariable("ad_pk") String adPk,
                                           @PathVariable("id") Integer id,
                                           @Valid @RequestBody Comment body);

}
