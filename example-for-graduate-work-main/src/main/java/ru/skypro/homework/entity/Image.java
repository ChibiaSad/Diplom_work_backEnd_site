package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
@RequiredArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Long image_id;
    @Column(name = "filePath")
    private String filePath;

    @Column(name = "mediaType")
    private String mediaType;
    @Column(name = "fileSize")
    private long fileSize;
    @Lob
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
        return fileSize == image.fileSize && Objects.equals(image_id, image.image_id) && Objects.equals(filePath, image.filePath) && Objects.equals(mediaType, image.mediaType) && Arrays.equals(data, image.data) && Objects.equals(ads, image.ads);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(image_id, filePath, mediaType, fileSize, ads);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id_image=" + image_id +
                ", filePath='" + filePath +
                ", mediaType='" + mediaType +
                ", fileSize=" + fileSize +
                ", data=" + Arrays.toString(data) +
                ", ads=" + ads;
    }
}
