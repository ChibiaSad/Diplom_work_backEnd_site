package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdsNotFoundException;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl{
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public CommentDto addCommentToDb(Integer adsPk, CommentDto commentDto, String userName) {
        Ads ads = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        User user = userRepository.findById(commentDto.getAuthor()).orElseThrow(UserNotFoundException::new);
        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText(comment.getText());
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }


    public ResponseWrapperCommentDto getAllComments(Integer adsPk) {
        return null;
    }


    public CommentDto getAdsComment(Integer adsPk, Integer id) {
        return null;
    }


    public CommentDto updateAdsComment(Integer adsPk, Integer id, CommentDto adsCommentDto) {
        return null;
    }


    public Void deleteAdsComment(Integer adsPk, Integer id) {
        return null;
    }
}
