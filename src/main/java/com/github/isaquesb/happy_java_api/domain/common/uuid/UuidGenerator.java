package com.github.isaquesb.happy_java_api.domain.common.uuid;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {

    public UUID generate() {
        return Generators.timeBasedEpochGenerator().generate();
    }
}
