package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
@RequiredArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image", nullable = false)
    private Long id_image;
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "file_size")
    private long fileSize;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "data")
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return fileSize == image.fileSize && Objects.equals(id_image, image.id_image) && Objects.equals(filePath, image.filePath) && Objects.equals(mediaType, image.mediaType) && Arrays.equals(data, image.data) && Objects.equals(ads, image.ads);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id_image, filePath, mediaType, fileSize, ads);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id_image=" + id_image +
                ", filePath='" + filePath +
                ", mediaType='" + mediaType +
                ", fileSize=" + fileSize +
                ", data=" + Arrays.toString(data) +
                ", ads=" + ads;
    }
}
