package com.mt.claimportaljava.utils.model;

import com.mt.claimportaljava.dtos.CreateLocationDto;
import com.mt.claimportaljava.models.Location;

public class LocationBuilder {
    private Location location;

    public LocationBuilder() {
        this.location = new Location();
    }

    public Location build() {
        return this.location;
    }

    public void withDataFromDto(CreateLocationDto createLocationDto) {
        withAddress(createLocationDto.getAddress());
        withPostalCode(createLocationDto.getPostalCode());
        withCity(createLocationDto.getCity());
        withCountry(createLocationDto.getCountry());
    }

    public void withAddress(String address) {
        this.location.setAddress(address);
    }

    public void withPostalCode(String postalCode) {
        this.location.setPostalcode(postalCode);
    }

    public void withCity(String city) {
        this.location.setCity(city);
    }

    public void withCountry(String country) {
        this.location.setCountry(country);
    }
}
