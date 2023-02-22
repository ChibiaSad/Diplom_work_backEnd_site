package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.controller.api.AdsApi;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.impl.AdsServiceImpl;
import ru.skypro.homework.service.impl.CommentServiceImpl;

import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AdsApiController implements AdsApi {
    private final AdsServiceImpl adsService;
    private final CommentServiceImpl commentService;

    public ResponseEntity<AdsDto> addAds(CreateAdsDto properties, MultipartFile image) throws IOException {
        return ResponseEntity.ok(adsService.addAdsToDb(properties, image));
    }

    public ResponseEntity<CommentDto> addComments(Integer adPk, CommentDto body) {
        return ResponseEntity.ok(commentService.addCommentToDb(adPk, body, ""));
    }

    public ResponseEntity<Void> deleteComments(Integer adPk, Integer id) {
        return ResponseEntity.ok(commentService.deleteAdsComment(adPk, id));
    }

    public ResponseEntity<ResponseWrapperAdsDto> getALLAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    public ResponseEntity<FullAdsDto> getAds(Integer id) {
        return ResponseEntity.ok(adsService.getAds(id));
    }

    @Override
    public ResponseEntity<ResponseWrapperAdsDto> getAdsMeUsingGET() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    public ResponseEntity<ResponseWrapperCommentDto> getComments(Integer adPk) {
        return ResponseEntity.ok(commentService.getAllComments(adPk));
    }

    public ResponseEntity<CommentDto> getComments(Integer adPk, Integer id) {
        return ResponseEntity.ok(commentService.getAdsComment(adPk, id));
    }

    public ResponseEntity<Void> removeAds(Integer id) {
        return ResponseEntity.ok(adsService.deleteAds(id));
    }

    public ResponseEntity<AdsDto> updateAds(Integer id, CreateAdsDto body) {
        return ResponseEntity.ok(adsService.updateAds(id, body));
    }

    public ResponseEntity<CommentDto> updateComments(Integer adPk, Integer id, CommentDto body) {
        return ResponseEntity.ok(commentService.updateAdsComment(adPk, id, body));
    }
}

