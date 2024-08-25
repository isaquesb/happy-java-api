package com.github.isaquesb.happy_java_api.domain.orphanages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrphanageRepository extends JpaRepository<Orphanage, Long> {
    public Orphanage findByUuid(String uuid);
}
