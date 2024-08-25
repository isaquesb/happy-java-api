package com.github.isaquesb.happy_java_api.domain.addresses;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Street is required")
    @Length(max = 100, message = "Street must be less than 100 characters")
    private String street;

    @Column
    private String number;

    @Length(max = 100, message = "Complement must be less than 100 characters")
    private String complement;

    @Column(nullable = false)
    @NotBlank(message = "Neighborhood is required")
    @Length(max = 100, message = "Neighborhood must be less than 100 characters")
    private String neighborhood;

    @Column(nullable = false)
    @NotBlank(message = "City is required")
    @Length(max = 100, message = "City must be less than 100 characters")
    private String city;

    @Column(nullable = false)
    @NotBlank(message = "State is required")
    @Length(min = 2, max = 2, message = "State must be 2 characters")
    private String state;

    @Column(nullable = false)
    @NotBlank(message = "Zip code is required")
    @Length(min = 8, max = 8, message = "Zip code must be 8 characters")
    private String zipCode;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
