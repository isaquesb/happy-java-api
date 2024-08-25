package com.github.isaquesb.happy_java_api.app.http.controllers.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.exceptions.NotFoundException;
import com.github.isaquesb.happy_java_api.domain.orphanages.OrphanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orphanages")
public class OrphanagesController {

    @Autowired
    private OrphanageService orphanageService;

    @GetMapping
    public List<OrphanageResource> findAll() {
        return OrphanageResource.fromList(orphanageService.findAll());
    }

    @GetMapping("/{uuid}")
    public OrphanageResource findByUuid(@PathVariable String uuid) {
        var orphanage = orphanageService.findByUuid(uuid);

        if (orphanage == null) {
            throw new NotFoundException("Orphanage not found");
        }

        return OrphanageResource.from(orphanage);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Object> delete(@PathVariable String uuid) {
        orphanageService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
