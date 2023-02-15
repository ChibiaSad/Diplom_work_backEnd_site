package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
@RequiredArgsConstructor
@Entity
@Table(name = "avatar")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avatar_id", nullable = false)
    private Long avatar_id;
    @Column(name = "filePath")
    private String filePath;
    @Column(name = "mediaType")
    private String mediaType;
    @Column(name = "fileSize")
    private long fileSize;
    @Lob
    @Column(name = "data")
    private byte[] data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return fileSize == avatar.fileSize && Objects.equals(avatar_id, avatar.avatar_id) && Objects.equals(filePath, avatar.filePath) && Objects.equals(mediaType, avatar.mediaType) && Arrays.equals(data, avatar.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(avatar_id, filePath, mediaType, fileSize);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Avatar" + avatar_id + filePath + mediaType + fileSize + Arrays.toString(data);
    }



}
