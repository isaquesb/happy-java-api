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
}
