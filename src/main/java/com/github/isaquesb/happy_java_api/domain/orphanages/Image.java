package com.github.isaquesb.happy_java_api.domain.orphanages;

import jakarta.persistence.*;

@Entity
@Table(name = "orphanages_images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 36)
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

    @Column(nullable = false)
    private String disk;

    @Column(nullable = false)
    private String path;

    @Column
    private String downloadUrl;

    @Embedded
    private ImageMetadata metadata;

    public Image() {
    }

    public Image(String disk, String url) {
        this.disk = disk;
        this.path = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Orphanage getOrphanage() {
        return orphanage;
    }

    public void setOrphanage(Orphanage orphanage) {
        this.orphanage = orphanage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ImageMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ImageMetadata metadata) {
        this.metadata = metadata;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
