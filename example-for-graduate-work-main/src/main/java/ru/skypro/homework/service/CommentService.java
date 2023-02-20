package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;

public interface CommentService {
    ResponseEntity<CommentDto> addCommentToDb(Integer adsPk, CommentDto commentDto, String authorUsername);

    ResponseEntity<ResponseWrapperCommentDto> getAllComments(Integer adsPk);

    ResponseEntity<CommentDto> getAdsComment(Integer adsPk, Integer id);

    ResponseEntity<CommentDto> updateAdsComment(Integer adsPk, Integer id, CommentDto adsCommentDto);

    ResponseEntity<Void> deleteAdsComment(Integer adsPk, Integer id);
}
