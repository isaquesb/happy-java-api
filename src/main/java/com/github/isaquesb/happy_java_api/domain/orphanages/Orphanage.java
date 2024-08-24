package com.github.isaquesb.happy_java_api.domain.orphanages;

import com.github.isaquesb.happy_java_api.domain.addresses.Address;
import com.github.isaquesb.happy_java_api.domain.addresses.Coordinates;
import com.github.isaquesb.happy_java_api.domain.addresses.Location;
import com.github.isaquesb.happy_java_api.domain.common.database.audit.AuditableEntity;
import com.github.isaquesb.happy_java_api.domain.common.validation.rules.OneOfTwo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orphanages")
@OneOfTwo(firstField = "coordinates", secondField = "address", message = "Coordinates or Address is required")
public class Orphanage extends AuditableEntity implements Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 36)
    private String uuid;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name is required")
    @Length(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "About is required")
    private String about;

    @Column(nullable = false)
    @NotBlank(message = "Instructions is required")
    private String instructions;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Opening Hours is required")
    @Length(max = 100, message = "Opening Hours must be less than 100 characters")
    private String openingHours;

    @Column(nullable = false)
    @NotNull(message = "Open On Weekends is required")
    private Boolean openOnWeekends;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @Valid
    private Address address;

    @Embedded
    @Valid
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
