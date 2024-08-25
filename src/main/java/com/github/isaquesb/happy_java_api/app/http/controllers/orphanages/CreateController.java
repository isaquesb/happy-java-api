package com.github.isaquesb.happy_java_api.app.http.controllers.orphanages;

import com.github.isaquesb.happy_java_api.domain.orphanages.Orphanage;
import com.github.isaquesb.happy_java_api.domain.orphanages.create_steps.Chain;
import com.github.isaquesb.happy_java_api.domain.orphanages.create_steps.CreateRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/orphanages")
public class CreateController {
    @Autowired
    private Chain chain;

    @Transactional
    @PostMapping
    public ResponseEntity<CreatedResponse> create(
            @Valid @RequestPart Orphanage orphanage,
            @RequestParam("files") MultipartFile[] files
    ) throws Exception {
        var request = new CreateRequest(orphanage, files);
        var uuid = chain.execute(request);


        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedResponse(uuid));
    }
}
