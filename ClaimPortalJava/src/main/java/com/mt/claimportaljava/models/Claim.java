package com.mt.claimportaljava.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "claim")
public class Claim {
    @Id
    @GeneratedValue
    private Long id;
    private String claimNumber;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policy_id", referencedColumnName = "id")
    private Policy policy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "losslocation_id", referencedColumnName = "id")
    private Location lossLocation;
    private Date lossDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reporter_id", referencedColumnName = "id")
    private Contact reporter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "claimant_id", referencedColumnName = "id")
    private Contact claimant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Location getLossLocation() {
        return lossLocation;
    }

    public void setLossLocation(Location lossLocation) {
        this.lossLocation = lossLocation;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public Contact getReporter() {
        return reporter;
    }

    public void setReporter(Contact reporter) {
        this.reporter = reporter;
    }

    public Contact getClaimant() {
        return claimant;
    }

    public void setClaimant(Contact claimant) {
        this.claimant = claimant;
    }
}
