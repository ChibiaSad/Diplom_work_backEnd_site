package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private AdsRepository adsRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    void addCommentToDb() {

        Integer adsPk = 1;

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(1);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        Mockito.when(adsRepository.findById(adsPk)).thenReturn(Optional.of(ads));
        Mockito.when(userService.getDefaultUser()).thenReturn(user);

        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(1);
        commentDto.setText("Очень вкусный пирог");
        commentDto.setCreatedAt("2023-02-25");

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText(commentDto.getText());
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Mockito.when(commentRepository.save(comment)).thenReturn(comment);

        assertThat(commentService.addCommentToDb(adsPk, commentDto, "Ivan")).isNotNull().isEqualTo(commentDto);
    }

    @Test
    void getAllComments() {
        Integer adsPk = 1;

        List<CommentDto> listCommentDto = new ArrayList<>();

        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(1);
        commentDto.setText("Очень вкусный пирог");
        commentDto.setCreatedAt("2023-02-25");

        CommentDto commentDto1 = new CommentDto();
        commentDto1.setAuthor(1);
        commentDto1.setText("Очень вкусный торт");
        commentDto1.setCreatedAt("2023-02-25");

        CommentDto commentDto2 = new CommentDto();
        commentDto2.setAuthor(1);
        commentDto2.setText("Очень вкусный коктейль");
        commentDto2.setCreatedAt("2023-02-25");

        listCommentDto.add(commentDto);
        listCommentDto.add(commentDto1);
        listCommentDto.add(commentDto2);

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(1);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        List<Comment> listComment = new ArrayList<>();

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText(commentDto.getText());
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Comment comment1 = new Comment();
        comment1.setAuthor(user);
        comment1.setAds(ads);
        comment1.setText(commentDto1.getText());
        comment1.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Comment comment2 = new Comment();
        comment2.setAuthor(user);
        comment2.setAds(ads);
        comment2.setText(commentDto2.getText());
        comment2.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        listComment.add(comment);
        listComment.add(comment1);
        listComment.add(comment2);

        ResponseWrapperCommentDto response = new ResponseWrapperCommentDto();
        response.setCount(listCommentDto.size());
        response.setResults(listCommentDto);

        Mockito.when(commentRepository.findAllByAdsId(adsPk)).thenReturn(listComment);

        assertThat(commentService.getAllComments(adsPk)).isNotNull().isEqualTo(response);

    }

    @Test
    void getAdsComment() {

        Integer id = 1;
        Integer adsPk = 3;

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(1);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText("Очень вкусный пирог с яблоками");
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Mockito.when(commentRepository.findByIdAndAdsId(id, adsPk)).thenReturn(Optional.of(comment));

        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(comment);

        assertThat(commentService.getAdsComment(adsPk, id)).isNotNull().isEqualTo(commentDto);
    }

    @Test
    void updateAdsComment() {
        Integer id = 1;
        Integer adsPk = 3;

        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Ads ads = new Ads();
        ads.setId(1);
        ads.setTitle("Пирог");
        ads.setPrice(125);
        ads.setDescription("Вкусный пирог");
        ads.setUser(user);

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setAds(ads);
        comment.setText("Очень вкусный пирог с яблоками");
        comment.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(comment);

        Mockito.when(commentRepository.findByIdAndAdsId(id, adsPk)).thenReturn(Optional.of(comment));
        Mockito.when(commentRepository.save(comment)).thenReturn(comment);

        assertThat(commentService.updateAdsComment(adsPk, id, commentDto)).isEqualTo(commentDto);

    }

    @Test
    void deleteAdsComment() {
        Integer adsPk = 123;
        Integer id = 1;

        commentService.deleteAdsComment(adsPk, id);

        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        verify(commentRepository).deleteByIdAndAdsId(argumentCaptor.capture(),
                integerArgumentCaptor.capture());

        Integer actual1 = argumentCaptor.getValue();
        Integer actual2 = integerArgumentCaptor.getValue();

        assertThat(actual1).isEqualTo(id);
        assertThat(actual2).isEqualTo(adsPk);

    }

     @Test
    void deleteAllAdsComment() {
        Integer adsPk = 1;

        commentService.deleteAllAdsComment(adsPk);

         ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
         verify(commentRepository).deleteAllByAdsId(argumentCaptor.capture());
         Integer actual = argumentCaptor.getValue();
         assertThat(actual).isEqualTo(adsPk);
    }
}