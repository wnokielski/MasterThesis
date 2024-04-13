package com.mt.claimportaljava.dtos;

import java.util.Date;

public class CreateContactDto {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String nin;
    private CreateLocationDto primaryAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public CreateLocationDto getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(CreateLocationDto primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
