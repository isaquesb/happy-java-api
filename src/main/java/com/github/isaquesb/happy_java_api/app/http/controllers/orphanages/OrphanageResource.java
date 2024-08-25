package com.github.isaquesb.happy_java_api.app.http.controllers.orphanages;

import com.github.isaquesb.happy_java_api.domain.orphanages.Orphanage;

import java.util.List;

public class OrphanageResource {

    public String id;

    public String name;

    public String about;

    public String instructions;

    public String openingHours;

    public Boolean openOnWeekends;

    public List<ImageResource> images;

    public static OrphanageResource from(Orphanage orphanage) {
        OrphanageResource resource = new OrphanageResource();

        resource.id = orphanage.getUuid();
        resource.name = orphanage.getName();
        resource.about = orphanage.getAbout();
        resource.instructions = orphanage.getInstructions();
        resource.openingHours = orphanage.getOpeningHours();
        resource.openOnWeekends = orphanage.getOpenOnWeekends();
        resource.images = ImageResource.fromList(orphanage.getImages());

        return resource;
    }

    public static List<OrphanageResource> fromList(List<Orphanage> orphanages) {
        return orphanages.stream().map(OrphanageResource::from).toList();
    }
}
