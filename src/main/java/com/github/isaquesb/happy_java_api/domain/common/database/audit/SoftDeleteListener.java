package com.github.isaquesb.happy_java_api.domain.common.database.audit;

import jakarta.persistence.PreRemove;

import java.time.LocalDateTime;

public class SoftDeleteListener {

    @PreRemove
    public void preRemove(SoftDeletable entity) {
        entity.setDeletedAt(LocalDateTime.now());
    }
}
