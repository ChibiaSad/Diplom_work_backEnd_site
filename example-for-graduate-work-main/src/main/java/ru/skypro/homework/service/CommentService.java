package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;

public interface CommentService {
    CommentDto addCommentToDb(Integer adsPk, CommentDto commentDto, String authorUsername);

    ResponseWrapperCommentDto getAllComments(Integer adsPk);

    CommentDto getAdsComment(Integer adsPk, Integer id);

    CommentDto updateAdsComment(Integer adsPk, Integer id, CommentDto adsCommentDto);

    Void deleteAdsComment(Integer adsPk, Integer id);
}
