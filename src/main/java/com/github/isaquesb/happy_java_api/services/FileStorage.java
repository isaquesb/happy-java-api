package com.github.isaquesb.happy_java_api.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
    public void init();

    public Path put(MultipartFile file, String destinationPath);

    public Resource get(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
