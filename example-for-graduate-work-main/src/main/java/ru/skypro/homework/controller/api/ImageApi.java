package ru.skypro.homework.controller.api;

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

@Validated
@RequestMapping("/image")
public interface ImageApi {

    @Operation(summary = "updateAdsImage", tags = "Изображения",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    mediaType = MediaType.IMAGE_JPEG_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = byte[].class)))),
                    @ApiResponse(responseCode = "404", description = "Not Found")}
    )
    @PatchMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity <byte[]> updateImage(@PathVariable("id") Integer id,
                                             @Valid @RequestPart("image") MultipartFile image);

}
