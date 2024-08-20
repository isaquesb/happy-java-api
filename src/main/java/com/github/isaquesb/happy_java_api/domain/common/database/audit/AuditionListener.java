package com.github.isaquesb.happy_java_api.domain.common.database.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditionListener {
    @PrePersist
    public void prePersist(HasAudition entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(HasAudition entity) {
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
