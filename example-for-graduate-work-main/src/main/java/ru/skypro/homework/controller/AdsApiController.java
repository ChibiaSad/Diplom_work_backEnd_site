package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.controller.api.AdsApi;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.impl.AdsServiceImpl;
import ru.skypro.homework.service.impl.CommentServiceImpl;
import ru.skypro.homework.service.impl.ImageServiceImpl;

import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AdsApiController implements AdsApi {
    private final AdsServiceImpl adsService;
    private final CommentServiceImpl commentService;
    private final ImageServiceImpl imageService;

    public ResponseEntity<AdsDto> addAds(CreateAdsDto properties, MultipartFile image, Authentication auth) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(adsService.addAdsToDb(properties, image, auth));
    }

    public ResponseEntity<CommentDto> addComments(Integer adPk, CommentDto body, Authentication auth) {
        return ResponseEntity.ok(commentService.addCommentToDb(adPk, body, auth));
    }

    public ResponseEntity<Void> deleteComments(Integer adPk, Integer id, Authentication auth) {
        commentService.deleteAdsComment(adPk, id, auth);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ResponseWrapperAdsDto> getALLAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    public ResponseEntity<FullAdsDto> getAds(Integer id) {
        return ResponseEntity.ok(adsService.getAds(id));
    }

    public ResponseEntity<ResponseWrapperAdsDto> getAdsMeUsingGET(Authentication auth) {
        return ResponseEntity.ok(adsService.getAdsMe(auth));
    }

    public ResponseEntity<ResponseWrapperCommentDto> getComments(Integer adPk) {
        return ResponseEntity.ok(commentService.getAllComments(adPk));
    }

    public ResponseEntity<CommentDto> getComments(Integer adPk, Integer id) {
        return ResponseEntity.ok(commentService.getAdsComment(adPk, id));
    }

    public ResponseEntity<Void> removeAds(Integer id, Authentication auth) {
        adsService.deleteAds(id, auth);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<AdsDto> updateAds(Integer id, CreateAdsDto body, Authentication auth) {
        return ResponseEntity.ok(adsService.updateAds(id, body, auth));
    }

    public ResponseEntity<CommentDto> updateComments(Integer adPk, Integer id, CommentDto body, Authentication auth) {
        return ResponseEntity.ok(commentService.updateAdsComment(adPk, id, body, auth));
    }

    //почему-то при update картинки ads фронт обращается сюда
    public ResponseEntity<byte[]> updateImage(Integer adPk, MultipartFile image, Authentication auth) throws IOException {
        byte[] data = imageService.updateImage(adPk, image, auth);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(data.length)
                .body(data);
    }
}

