package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.service.CommentService;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentDto addCommentToDb(Integer adsPk, CommentDto commentDto, String authorUsername) {
        return null;
    }

    @Override
    public ResponseWrapperCommentDto getAllComments(Integer adsPk) {
        return null;
    }

    @Override
    public CommentDto getAdsComment(Integer adsPk, Integer id) {
        return null;
    }

    @Override
    public CommentDto updateAdsComment(Integer adsPk, Integer id, CommentDto adsCommentDto) {
        return null;
    }

    @Override
    public Void deleteAdsComment(Integer adsPk, Integer id) {
        return null;
    }
}
