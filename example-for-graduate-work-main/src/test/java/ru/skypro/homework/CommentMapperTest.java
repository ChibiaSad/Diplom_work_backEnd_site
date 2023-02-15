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
        comment.setAuthor(1);
        comment.setCreatedAt("create");
        comment.setPk(111);
        comment.setText("Text");

        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(comment);

        assertThat(commentDto).isNotNull();
        assertThat(commentDto.getAuthor()).isEqualTo(1);
        assertThat(commentDto.getCreatedAt()).isEqualTo("create");
        assertThat(commentDto.getPk()).isEqualTo(111);
        assertThat(commentDto.getText()).isEqualTo("Text");

    }

    @Test
    public void shouldMapCommentDtoToComment() {
        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(1);
        commentDto.setCreatedAt("create");
        commentDto.setPk(111);
        commentDto.setText("Text");

        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDto);

        assertThat(comment).isNotNull();
        assertThat(comment.getAuthor()).isEqualTo(1);
        assertThat(comment.getCreatedAt()).isEqualTo("create");
        assertThat(comment.getPk()).isEqualTo(111);
        assertThat(comment.getText()).isEqualTo("Text");
    }
}

