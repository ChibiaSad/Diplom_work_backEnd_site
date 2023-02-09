package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/image")
public interface ImageApi {

    @Operation(summary = "updateAdsImage", tags = "Изображения",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = byte[].class)))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<List<byte[]>> updateImage(@PathVariable("id") Integer id,
                                             @Valid @RequestPart("image") MultipartFile image);

}
