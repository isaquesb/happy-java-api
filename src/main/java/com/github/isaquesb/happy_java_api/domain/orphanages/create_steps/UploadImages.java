package com.github.isaquesb.happy_java_api.domain.orphanages.create_steps;

import com.github.isaquesb.happy_java_api.domain.orphanages.ImageService;
import com.github.isaquesb.happy_java_api.domain.orphanages.OrphanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UploadImages implements Step {

    @Autowired
    private ImageService imageService;

    @Autowired
    private OrphanageService orphanageService;

    @Override
    public void fill(CreateRequest request) throws Exception {
        var images = imageService.createFromFiles(request.files(), request.orphanage().getUuid());
        orphanageService.setImages(request.orphanage(), images);
    }
}
