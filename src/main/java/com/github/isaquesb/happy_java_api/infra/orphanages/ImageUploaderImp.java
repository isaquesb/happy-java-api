package com.github.isaquesb.happy_java_api.infra.orphanages;

import com.github.isaquesb.happy_java_api.domain.orphanages.Image;
import com.github.isaquesb.happy_java_api.domain.orphanages.ImageFactory;
import com.github.isaquesb.happy_java_api.domain.orphanages.ImageUploader;
import com.github.isaquesb.happy_java_api.services.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ImageUploaderImp implements ImageUploader {
    @Autowired
    private FileStorage fileStorage;

    @Override
    public Image createFromFile(MultipartFile file, String destinationPath) throws Exception {
        var filePath = fileStorage.put(file, destinationPath);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path(filePath.toString())
            .toUriString();

        Image image = ImageFactory.create();

        image.setDisk("local");
        image.setPath(filePath.toString());
        image.setDownloadUrl(downloadUrl);
        image.setMetadata(ImageFactory.metadataFromFile(file));

        return image;
    }
}
