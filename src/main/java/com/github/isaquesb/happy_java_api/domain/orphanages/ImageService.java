package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {
    @Autowired
    private ImageUploader imageUploader;

    private Image createFromFile(MultipartFile file, String destinationPath) throws ValidationException, Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw  new ValidationException("Filename contains invalid path sequence " + fileName);
            }

            if (file.getBytes().length > (1024 * 1024)) {
                throw new ValidationException("File size exceeds maximum limit: 1MB");
            }

            if (!isImage(file)) {
                throw new ValidationException("File type is not supported: " + file.getContentType());
            }

            return imageUploader.createFromFile(file, destinationPath);
        } catch (MaxUploadSizeExceededException e) {
            throw new ValidationException("File size exceeds maximum limit");
        }
    }

    public List<Image> createFromFiles(MultipartFile[] files, String destinationPath) throws ValidationException, Exception {
        return Arrays.stream(files)
            .map(file -> {
                try {
                    return createFromFile(file, destinationPath);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            })
            .toList();
    }

    private Boolean isImage(MultipartFile file) {
        return Objects.equals(file.getContentType(), "image/jpeg") || Objects.equals(file.getContentType(), "image/png");
    }
}
