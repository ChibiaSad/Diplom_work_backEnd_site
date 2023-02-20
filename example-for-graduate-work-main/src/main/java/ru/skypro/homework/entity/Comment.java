package ru.skypro.homework.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "comment")
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    @Column(name = "comment_created_at")
    private String createdAt;


    @Column(name = "comment_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

}
