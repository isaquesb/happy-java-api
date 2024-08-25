package com.github.isaquesb.happy_java_api.app.http.controllers.orphanages;

import com.github.isaquesb.happy_java_api.domain.orphanages.Image;
import com.github.isaquesb.happy_java_api.domain.orphanages.ImageMetadata;

import java.util.List;

public class ImageResource {

    public String id;

    public String downloadUrl;

    public ImageMetadata metadata;

    public static List<ImageResource> fromList(List<Image> images) {
        return images.stream().map(ImageResource::from).toList();
    }

    public static ImageResource from(Image image) {
        ImageResource resource = new ImageResource();
        resource.id = image.getUuid();
        resource.downloadUrl = image.getDownloadUrl();
        resource.metadata = image.getMetadata();
        return resource;
    }
}
