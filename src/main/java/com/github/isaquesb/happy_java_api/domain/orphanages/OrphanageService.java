package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.common.exceptions.NotFoundException;
import com.github.isaquesb.happy_java_api.domain.common.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrphanageService {
    @Autowired
    private OrphanageRepository orphanageRepository;

    @Autowired
    private ImageRepository imageRepository;

    private final UuidGenerator uuidGenerator = new UuidGenerator();

    public OrphanageService() {
    }

    public List<Orphanage> findAll() {
        return orphanageRepository.findAll();
    }

    public Orphanage findByUuid(String uuid) {
        return orphanageRepository.findByUuid(uuid);
    }

    public String save(Orphanage orphanage) {
        if (null == orphanage.getUuid()) {
            orphanage.setUuid(uuidGenerator.generate().toString());
        }
        orphanageRepository.save(orphanage);
        return orphanage.getUuid();
    }

    public void delete(String uuid) {
        Orphanage row = findByUuid(uuid);
        if (null == row) {
            throw new NotFoundException("Orphanage not found");
        }

        orphanageRepository.delete(row);
    }

    public void setImages(Orphanage orphanage, List<Image> images) {
        for (Image image : images) {
            image.setOrphanage(orphanage);
            imageRepository.save(image);
        }
    }
}
