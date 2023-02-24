package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.mapper.CommentMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentMapperTest {
    @Test
    public void shouldMapCommentToCommentDto() {
        Comment comment = new Comment();
        comment.setId(1);
        comment.setCreatedAt("create");
        comment.setText("Text");

        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(comment);

        assertThat(commentDto).isNotNull();
        assertThat(commentDto.getAuthor()).isEqualTo(1);
        assertThat(commentDto.getCreatedAt()).isEqualTo("create");
        assertThat(commentDto.getText()).isEqualTo("Text");

    }

//    @Test
//    public void shouldMapCommentDtoToComment() {
//        CommentDto commentDto = new CommentDto();
//        commentDto.setAuthor(1);
//        commentDto.setCreatedAt("create");
//        commentDto.setText("Text");
//
//        Comment comment = CommentMapper.INSTANCE.c(commentDto);
//
//        assertThat(comment).isNotNull();
//        assertThat(comment.getId()).isEqualTo(1);
//        assertThat(comment.getCreatedAt()).isEqualTo("create");
//        assertThat(comment.getText()).isEqualTo("Text");
//    }
}

