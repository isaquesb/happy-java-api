package com.github.isaquesb.happy_java_api.domain.orphanages.create_steps;

import com.github.isaquesb.happy_java_api.domain.orphanages.OrphanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistOrphanage implements Step {
    @Autowired
    private OrphanageService orphanageService;

    @Override
    public void fill(CreateRequest request) throws Exception {
        orphanageService.save(request.orphanage());
    }
}
