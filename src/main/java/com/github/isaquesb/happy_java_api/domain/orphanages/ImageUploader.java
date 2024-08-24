package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.exceptions.ValidationException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploader {
    Image createFromFile(MultipartFile file) throws ValidationException, Exception;
}
