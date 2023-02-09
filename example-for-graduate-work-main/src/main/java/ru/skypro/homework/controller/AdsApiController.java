package ru.skypro.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AdsApiController implements AdsApi {
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    public ResponseEntity<Ads> addAds(CreateAds properties, MultipartFile image) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ads>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ],\n  " +
                        "\"author\" : 6,\n  \"price\" : 5,\n  \"pk\" : 1,\n  \"title\" : \"title\"\n}", Ads.class),
                        HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<Ads>(HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<Ads>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Comment> addComments(String adPk, Comment body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Comment>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n  " +
                        "\"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", Comment.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<Comment>(HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteComments(String adPk, Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<ResponseWrapperAds> getALLAds() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperAds>(objectMapper.readValue("{\n  \"count\" : 0,\n  " +
                        "\"results\" : [ {\n    \"image\" : [ \"image\", \"image\" ],\n    \"author\" : 6,\n    " +
                        "\"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : \"title\"\n  }, {\n    \"image\" : [ \"image\", " +
                        "\"image\" ],\n    \"author\" : 6,\n    \"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : " +
                        "\"title\"\n  } ]\n}", ResponseWrapperAds.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperAds>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperAds>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<FullAds> getAds(Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FullAds>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ]," +
                        "\n  \"authorLastName\" : \"authorLastName\",\n  \"authorFirstName\" : \"authorFirstName\",\n " +
                        " \"phone\" : \"phone\",\n  \"price\" : 6,\n  \"description\" : \"description\",\n  \"pk\" : 0," +
                        "\n  \"title\" : \"title\",\n  \"email\" : \"email\"\n}", FullAds.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<FullAds>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FullAds>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseWrapperAds> getAdsMeUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperAds>(objectMapper.readValue("{\n  \"count\" : 0,\n  \"results\" " +
                                ": [ {\n    \"image\" : [ \"image\", \"image\" ],\n    \"author\" : 6,\n    \"price\" : 5,\n   " +
                                " \"pk\" : 1,\n    \"title\" : \"title\"\n  }, {\n    \"image\" : [ \"image\", \"image\" ],\n  " +
                                "  \"author\" : 6,\n    \"price\" : 5,\n    \"pk\" : 1,\n    \"title\" : \"title\"\n  } ]\n}",
                        ResponseWrapperAds.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperAds>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperAds>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseWrapperComment> getComments(String adPk) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseWrapperComment>(objectMapper.readValue("{\n  \"count\" : 0,\n  " +
                        "\"results\" : [ {\n    \"createdAt\" : \"createdAt\",\n    \"author\" : 6,\n    \"pk\" : 1,\n  " +
                        "  \"text\" : \"text\"\n  }, {\n    \"createdAt\" : \"createdAt\",\n    \"author\" : 6,\n  " +
                        "  \"pk\" : 1,\n    \"text\" : \"text\"\n  } ]\n}", ResponseWrapperComment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<ResponseWrapperComment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseWrapperComment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Comment> getComments(String adPk, Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Comment>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n " +
                        " \"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", Comment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<Comment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Comment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> removeAds(Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ads> updateAds(Integer id, CreateAds body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ads>(objectMapper.readValue("{\n  \"image\" : [ \"image\", \"image\" ],\n " +
                        " \"author\" : 6,\n  \"price\" : 5,\n  \"pk\" : 1,\n  \"title\" : \"title\"\n}", Ads.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<Ads>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ads>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Comment> updateComments(String adPk, Integer id, Comment body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Comment>(objectMapper.readValue("{\n  \"createdAt\" : \"createdAt\",\n " +
                        " \"author\" : 6,\n  \"pk\" : 1,\n  \"text\" : \"text\"\n}", Comment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Не получилось сериализовать ответ для типа application/json", e);
                return new ResponseEntity<Comment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Comment>(HttpStatus.NOT_IMPLEMENTED);
    }
}

