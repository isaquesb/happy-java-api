package com.github.isaquesb.happy_java_api.domain.common.database.audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditionListener.class, SoftDeleteListener.class})
@FilterDef(name = "softDeleteFilter", parameters = @ParamDef(name = "deletedAt", type = LocalDateTime.class))
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
public abstract class AuditableEntity implements HasAudition, SoftDeletable {
    @Embedded
    private AuditionDates dates;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;


    public LocalDateTime getCreatedAt() {
        return dates.getCreatedAt();
    }

    public LocalDateTime getUpdatedAt() {
        return dates.getUpdatedAt();
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        dates.setCreatedAt(createdAt);
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        dates.setUpdatedAt(updatedAt);
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    public void markAsDeleted() {
        setDeletedAt(LocalDateTime.now());
    }
}
