package com.github.isaquesb.happy_java_api.domain.orphanages;

import jakarta.persistence.*;

@Embeddable
public class ImageMetadata {
    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Long size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
