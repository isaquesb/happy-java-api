package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.uuid.UuidGenerator;
import org.springframework.web.multipart.MultipartFile;

public class ImageFactory {

    private final static UuidGenerator uuidGenerator = new UuidGenerator();

    public static Image create()
    {
        var image = new Image();
        image.setUuid(uuidGenerator.generate().toString());
        return image;
    }

    public static ImageMetadata metadataFromFile(MultipartFile file) {
        var metadata = new ImageMetadata();
        metadata.setName(file.getOriginalFilename());
        metadata.setType(file.getContentType());
        metadata.setSize(file.getSize());
        return metadata;
    }
}
