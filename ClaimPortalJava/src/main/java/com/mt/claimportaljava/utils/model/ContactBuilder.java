package com.mt.claimportaljava.utils.model;

import com.mt.claimportaljava.dtos.CreateContactDto;
import com.mt.claimportaljava.models.Contact;
import com.mt.claimportaljava.models.Location;

import java.util.Date;

public class ContactBuilder {
    private Contact contact;

    public ContactBuilder() {
        this.contact = new Contact();
    }

    public Contact build() {
        return this.contact;
    }

    public void withDataFromDto(CreateContactDto createContactDto) {
        LocationBuilder primaryAddressBuilder = new LocationBuilder();
        primaryAddressBuilder.withDataFromDto(createContactDto.getPrimaryAddress());

        withFirstName(createContactDto.getFirstName());
        withLastName(createContactDto.getLastName());
        withDateOfBirth(createContactDto.getDateOfBirth());
        withNin(createContactDto.getNin());
        withPrimaryAddress(primaryAddressBuilder.build());
    }

    public void withFirstName(String firstName) {
        this.contact.setFirstName(firstName);
    }

    public void withLastName(String lastName) {
        this.contact.setLastName(lastName);
    }

    public void withDateOfBirth(Date dateOfBirth) {
        this.contact.setDateOfBirth(dateOfBirth);
    }

    public void withNin(String nin) {
        this.contact.setNin(nin);
    }

    public void withPrimaryAddress(Location primaryAddress) {
        this.contact.setPrimaryAddress(primaryAddress);
    }
}
