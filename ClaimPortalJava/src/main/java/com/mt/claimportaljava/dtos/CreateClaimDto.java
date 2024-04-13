package com.mt.claimportaljava.dtos;

import java.util.Date;

public class CreateClaimDto {
    private String description;
    private CreatePolicyDto policy;
    private CreateLocationDto lossLocation;
    private Date lossDate;
    private CreateContactDto reporter;
    private CreateContactDto claimant;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreatePolicyDto getPolicy() {
        return policy;
    }

    public void setPolicy(CreatePolicyDto policy) {
        this.policy = policy;
    }

    public CreateLocationDto getLossLocation() {
        return lossLocation;
    }

    public void setLossLocation(CreateLocationDto lossLocation) {
        this.lossLocation = lossLocation;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public CreateContactDto getReporter() {
        return reporter;
    }

    public void setReporter(CreateContactDto reporter) {
        this.reporter = reporter;
    }

    public CreateContactDto getClaimant() {
        return claimant;
    }

    public void setClaimant(CreateContactDto claimant) {
        this.claimant = claimant;
    }
}
