package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.service.CommentService;

public class CommentServiceImpl implements CommentService {
    @Override
    public ResponseEntity<CommentDto> addCommentToDb(Integer adsPk, CommentDto commentDto, String authorUsername) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapperCommentDto> getAllComments(Integer adsPk) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDto> getAdsComment(Integer adsPk, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDto> updateAdsComment(Integer adsPk, Integer id, CommentDto adsCommentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAdsComment(Integer adsPk, Integer id) {
        return null;
    }
}
