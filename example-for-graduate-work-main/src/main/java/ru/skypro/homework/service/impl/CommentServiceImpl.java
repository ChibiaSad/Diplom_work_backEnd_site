package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdsNotFoundException;
import ru.skypro.homework.exception.CommentNotFoundException;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl{
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;


    public CommentDto addCommentToDb(Integer adsPk, CommentDto commentDto, Authentication auth) {
        log.debug("method addCommentToDb started");
        Ads ads = adsRepository.findById(adsPk).orElseThrow(AdsNotFoundException::new);
        User user = userRepository.getUserByEmail(auth.getName()).orElseThrow(UserNotFoundException::new);
        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText(commentDto.getText());
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }


    public ResponseWrapperCommentDto getAllComments(Integer adsPk) {
        log.debug("method getAllComments started");
        List<CommentDto> list = commentRepository.findAllByAdsId(adsPk).stream()
                .map(CommentMapper.INSTANCE::commentToCommentDto)
                .collect(Collectors.toList());
        return CommentMapper.INSTANCE.CommentDtoToWrapperCommentDto(list, list.size());
    }


    public CommentDto getAdsComment(Integer adsPk, Integer id) {
        log.debug("method getAdsComment started");
        /*
        после открытия Ads фронт при любом следующем действии запрашивает комментарий еще раз,
        при удалении комментария вылетает Exception
        */
//        Comment comment = commentRepository.findByIdAndAdsId(id, adsPk).orElseThrow(CommentNotFoundException::new);
        Comment comment = commentRepository.findByIdAndAdsId(id, adsPk).orElse(null);
        return comment == null ? null : CommentMapper.INSTANCE.commentToCommentDto(comment);
    }


    public CommentDto updateAdsComment(Integer adsPk, Integer id, CommentDto commentDto, Authentication auth) {
        log.debug("method updateAdsComment started");
        Comment comment = commentRepository.findByIdAndAdsId(id, adsPk).orElseThrow(CommentNotFoundException::new);
        if(userService.checkPermission(auth, comment.getAuthor().getEmail())){
            if(commentDto.getText() != null){
                comment.setText(commentDto.getText());
            }
        }
        return CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }


    public void deleteAdsComment(Integer adsPk, Integer id, Authentication auth) {
        log.debug("method deleteAdsComment started");
        Comment comment = commentRepository.findByIdAndAdsId(id, adsPk).orElseThrow(CommentNotFoundException::new);
        if(userService.checkPermission(auth, comment.getAuthor().getEmail())){
            commentRepository.deleteByIdAndAdsId(id, adsPk);
        }
    }

    public void deleteAllAdsComment(Integer adsPk) {
        log.debug("method deleteAllAdsComment started");
        commentRepository.deleteAllByAdsId(adsPk);
    }
}
