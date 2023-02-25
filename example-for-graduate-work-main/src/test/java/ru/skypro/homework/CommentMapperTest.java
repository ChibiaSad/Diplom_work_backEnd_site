package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.CommentMapper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentMapperTest {
    @Test
    public void shouldMapCommentToCommentDto() {
        User user = new User();
        user.setId(1);
        user.setEmail("user@gmail.com");
        user.setPhone("+78005553535");
        user.setFirstName("First");
        user.setLastName("Last");

        Comment comment = new Comment();
        comment.setId(1);
        comment.setCreatedAt("create");
        comment.setText("Text");
        comment.setAuthor(user);

        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(comment);

        assertThat(commentDto).isNotNull();
        assertThat(commentDto.getAuthor()).isEqualTo(1);
        assertThat(commentDto.getCreatedAt()).isEqualTo("create");
        assertThat(commentDto.getText()).isEqualTo("Text");

    }

    @Test
    public void shouldMapCommentDtoToWrapperCommentDto(){

        CommentDto comment = new CommentDto();
        comment.setAuthor(1);
        comment.setCreatedAt("create");
        comment.setText("Text");
        comment.setPk(1);

        CommentDto comment1 = new CommentDto();
        comment1.setAuthor(2);
        comment1.setCreatedAt("create1");
        comment1.setText("Text1");
        comment1.setPk(3);

        List<CommentDto> dtoList = new ArrayList<>();
        dtoList.add(comment);
        dtoList.add(comment1);

        ResponseWrapperCommentDto respDto = new ResponseWrapperCommentDto();
        respDto.setCount(dtoList.size());
        respDto.setResults(dtoList);

        assertThat(CommentMapper.INSTANCE.CommentDtoToWrapperCommentDto(dtoList, dtoList.size())).isEqualTo(respDto);
    }

}

