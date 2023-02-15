package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

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
    private Long id;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "file_size")
    private long fileSize;
    @Lob()
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "data")
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return fileSize == avatar.fileSize && Objects.equals(id, avatar.id) && Objects.equals(filePath, avatar.filePath) && Objects.equals(mediaType, avatar.mediaType) && Arrays.equals(data, avatar.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, filePath, mediaType, fileSize);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Avatar" + id + filePath + mediaType + fileSize + Arrays.toString(data);
    }



}
