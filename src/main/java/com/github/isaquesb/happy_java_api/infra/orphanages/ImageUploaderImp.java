package com.github.isaquesb.happy_java_api.infra.orphanages;

import com.github.isaquesb.happy_java_api.domain.orphanages.Image;
import com.github.isaquesb.happy_java_api.domain.orphanages.ImageUploader;
import com.github.isaquesb.happy_java_api.services.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@Service
public class ImageUploaderImp implements ImageUploader {
    @Autowired
    private FileStorage fileStorage;

    @Override
    public Image createFromFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        fileStorage.save(file);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();

        var image = new Image();

        image.setDisk("local");
        image.setPath("uploads/" + fileName);
        image.setDownloadUrl(downloadUrl);

        return image;
    }
}
