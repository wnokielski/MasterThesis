package com.mt.claimportaljava.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String nin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insured_id", referencedColumnName = "id")
    private Location primaryAddress;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public Location getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Location primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
