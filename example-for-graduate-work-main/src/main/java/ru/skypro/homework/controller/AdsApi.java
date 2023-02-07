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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.*;

import javax.validation.Valid;

@Validated
public interface AdsApi {

    @Operation(summary = "addAds", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = Ads.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads",
            produces = {"*/*"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    ResponseEntity<Ads> addAds(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema())
                               @RequestParam(value = "properties", required = false) CreateAds properties,
                               @Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile image);


    @Operation(summary = "addComments", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = Comment.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{ad_pk}/comments",
            produces = {"*/*"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Comment> addComments(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("ad_pk") String adPk, @Parameter(in = ParameterIn.DEFAULT,
            description = "", required = true, schema = @Schema()) @Valid @RequestBody Comment body);


    @Operation(summary = "deleteComments", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{ad_pk}/comments/{id}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteComments(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("ad_pk") String adPk, @Parameter(in = ParameterIn.PATH, description = "",
            required = true, schema = @Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = ResponseWrapperAds.class)))})
    @RequestMapping(value = "/ads",
            produces = {"*/*"},
            method = RequestMethod.GET)
    ResponseEntity<ResponseWrapperAds> getALLAds();


    @Operation(summary = "getFullAd", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = FullAds.class))),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{id}",
            produces = {"*/*"},
            method = RequestMethod.GET)
    ResponseEntity<FullAds> getAds(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "getAdsMe", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = ResponseWrapperAds.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/me",
            produces = {"*/*"},
            method = RequestMethod.GET)
    ResponseEntity<ResponseWrapperAds> getAdsMeUsingGET(@Parameter(in = ParameterIn.QUERY, description = "",
            schema = @Schema()) @Valid @RequestParam(value = "authenticated", required = false) Boolean authenticated,
                                                        @Parameter(in = ParameterIn.QUERY, description = "",
                                                                schema = @Schema()) @Valid
                                                        @RequestParam(value = "authorities[0].authority",
                                                                required = false) String authorities0Authority,
                                                        @Parameter(in = ParameterIn.QUERY, description = "",
                                                                schema = @Schema()) @Valid
                                                        @RequestParam(value = "credentials", required = false)
                                                        Object credentials, @Parameter(in = ParameterIn.QUERY,
            description = "", schema = @Schema()) @Valid @RequestParam(value = "details", required = false)
                                                        Object details, @Parameter(in = ParameterIn.QUERY,
            description = "", schema = @Schema()) @Valid @RequestParam(value = "principal", required = false) Object principal);


    @Operation(summary = "getComments", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = ResponseWrapperComment.class))),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{ad_pk}/comments",
            produces = {"*/*"},
            method = RequestMethod.GET)
    ResponseEntity<ResponseWrapperComment> getComments(@Parameter(in = ParameterIn.PATH, description = "",
            required = true, schema = @Schema()) @PathVariable("ad_pk") String adPk);


    @Operation(summary = "getComments", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = Comment.class))),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{ad_pk}/comments/{id}",
            produces = {"*/*"},
            method = RequestMethod.GET)
    ResponseEntity<Comment> getComments1(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("ad_pk") String adPk, @Parameter(in = ParameterIn.PATH, description = "",
            required = true, schema = @Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "removeAds", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @RequestMapping(value = "/ads/{id}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> removeAds(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "updateAds", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = Ads.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{id}",
            produces = {"*/*"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<Ads> updateAds(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "",
            required = true, schema = @Schema()) @Valid @RequestBody CreateAds body);


    @Operation(summary = "updateComments", description = "", tags = {"Объявления"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*",
                    schema = @Schema(implementation = Comment.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized"),

            @ApiResponse(responseCode = "403", description = "Forbidden"),

            @ApiResponse(responseCode = "404", description = "Not Found")})
    @RequestMapping(value = "/ads/{ad_pk}/comments/{id}",
            produces = {"*/*"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<Comment> updateComments(@Parameter(in = ParameterIn.PATH, description = "", required = true,
            schema = @Schema()) @PathVariable("ad_pk") String adPk, @Parameter(in = ParameterIn.PATH, description = "",
            required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT,
            description = "", required = true, schema = @Schema()) @Valid @RequestBody Comment body);

}
