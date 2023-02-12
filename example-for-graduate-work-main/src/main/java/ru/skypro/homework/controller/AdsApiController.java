package ru.skypro.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AdsApiController implements AdsApi {
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    public ResponseEntity<AdsDto> addAds(CreateAdsDto properties, MultipartFile image) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AdsDto>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ],\n  " +
                        "\"author\" : 6,\n  \"price\" : 5,\n  \"pk\" : 1,\n  \"title\" : \"title\"\n}", AdsDto.class),
                        HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<AdsDto>(HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<AdsDto>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<CommentDto> addComments(String adPk, CommentDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommentDto>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n  " +
                        "\"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", CommentDto.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<CommentDto>(HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<CommentDto>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteComments(String adPk, Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<ResponseWrapperAdsDto> getALLAds() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperAdsDto>(objectMapper.readValue("{\n  \"count\" : 0,\n  " +
                        "\"results\" : [ {\n    \"image\" : [ \"image\", \"image\" ],\n    \"author\" : 6,\n    " +
                        "\"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : \"title\"\n  }, {\n    \"image\" : [ \"image\", " +
                        "\"image\" ],\n    \"author\" : 6,\n    \"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : " +
                        "\"title\"\n  } ]\n}", ResponseWrapperAdsDto.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperAdsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperAdsDto>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<FullAdsDto> getAds(Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FullAdsDto>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ]," +
                        "\n  \"authorLastName\" : \"authorLastName\",\n  \"authorFirstName\" : \"authorFirstName\",\n " +
                        " \"phone\" : \"phone\",\n  \"price\" : 6,\n  \"description\" : \"description\",\n  \"pk\" : 0," +
                        "\n  \"title\" : \"title\",\n  \"email\" : \"email\"\n}", FullAdsDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<FullAdsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FullAdsDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseWrapperAdsDto> getAdsMeUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperAdsDto>(objectMapper.readValue("{\n  \"count\" : 0,\n  \"results\" " +
                                ": [ {\n    \"image\" : [ \"image\", \"image\" ],\n    \"author\" : 6,\n    \"price\" : 5,\n   " +
                                " \"pk\" : 1,\n    \"title\" : \"title\"\n  }, {\n    \"image\" : [ \"image\", \"image\" ],\n  " +
                                "  \"author\" : 6,\n    \"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : \"title\"\n  } ]\n}",
                        ResponseWrapperAdsDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperAdsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperAdsDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseWrapperCommentDto> getComments(String adPk) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperCommentDto>(objectMapper.readValue("{\n  \"count\" : 0,\n  " +
                        "\"results\" : [ {\n    \"createdAt\" : \"createdAt\",\n    \"author\" : 6,\n    \"pk\" : 1,\n  " +
                        "  \"text\" : \"text\"\n  }, {\n    \"createdAt\" : \"createdAt\",\n    \"author\" : 6,\n  " +
                        "  \"pk\" : 1,\n    \"text\" : \"text\"\n  } ]\n}", ResponseWrapperCommentDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperCommentDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperCommentDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentDto> getComments(String adPk, Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommentDto>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n " +
                        " \"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", CommentDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<CommentDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommentDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> removeAds(Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AdsDto> updateAds(Integer id, CreateAdsDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AdsDto>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ],\n " +
                        " \"author\" : 6,\n  \"price\" : 5,\n  \"pk\" : 1,\n  \"title\" : \"title\"\n}", AdsDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<AdsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AdsDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentDto> updateComments(String adPk, Integer id, CommentDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommentDto>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n " +
                        " \"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", CommentDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<CommentDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommentDto>(HttpStatus.NOT_IMPLEMENTED);
    }
}

