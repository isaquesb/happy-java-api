package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.database.audit.AuditableEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "orphanages_images")
public class Image extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

    @Column(nullable = false)
    private String disk;

    @Column(nullable = false)
    private String path;

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
}
