package com.github.isaquesb.happy_java_api.app.http.controllers;

import com.github.isaquesb.happy_java_api.domain.orphanages.ImageService;
import com.github.isaquesb.happy_java_api.domain.orphanages.Orphanage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/orphanages")
public class OrphanagesController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<String> fileUploading(@Valid @RequestPart Orphanage orphanage, @RequestParam("files") MultipartFile[] files) throws Exception {
        //imageService.createFromFiles(files);
        return ResponseEntity.ok("Successfully uploaded the file to orphanage: " + orphanage.getName());
    }
}
