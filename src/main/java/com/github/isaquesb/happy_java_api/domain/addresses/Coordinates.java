package com.github.isaquesb.happy_java_api.domain.addresses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Coordinates {

    @Column
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    @NotNull(message = "Latitude is required")
    private Double latitude;

    @Column
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    @NotNull(message = "Longitude is required")
    private Double longitude;

    public Coordinates() {
    }

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
