package com.github.isaquesb.happy_java_api.domain.orphanages.create_steps;

import com.github.isaquesb.happy_java_api.domain.common.uuid.UuidGenerator;
import org.springframework.stereotype.Component;

@Component
public class SetUuid implements Step {

    private final UuidGenerator uuidGenerator = new UuidGenerator();

    @Override
    public void fill(CreateRequest request) {
        request.orphanage().setUuid(uuidGenerator.generate().toString());
    }
}
