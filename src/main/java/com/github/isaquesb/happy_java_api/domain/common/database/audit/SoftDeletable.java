package com.github.isaquesb.happy_java_api.domain.common.database.audit;

import java.time.LocalDateTime;

public interface SoftDeletable {
    LocalDateTime getDeletedAt();
    void setDeletedAt(LocalDateTime deletedAt);
}
