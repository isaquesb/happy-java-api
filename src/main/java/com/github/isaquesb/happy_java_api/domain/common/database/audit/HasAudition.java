package com.github.isaquesb.happy_java_api.domain.common.database.audit;

import java.time.LocalDateTime;

public interface HasAudition {
    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);

    void setUpdatedAt(LocalDateTime updatedAt);
}
