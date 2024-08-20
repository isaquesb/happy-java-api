package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.addresses.Address;
import com.github.isaquesb.happy_java_api.domain.addresses.Coordinates;
import com.github.isaquesb.happy_java_api.domain.addresses.Location;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orphanages")
public class Orphanage implements Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String about;

    @Column(nullable = false)
    private String instructions;

    @Column(nullable = false)
    private String openingHours;

    @Column(nullable = false)
    private Boolean openOnWeekends;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @Embedded
    private Coordinates coordinates;

    @OneToMany(mappedBy = "orphanage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    public Orphanage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Boolean getOpenOnWeekends() {
        return openOnWeekends;
    }

    public void setOpenOnWeekends(Boolean openOnWeekends) {
        this.openOnWeekends = openOnWeekends;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image) {
        images.add(image);
        image.setOrphanage(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setOrphanage(null);
    }
}
