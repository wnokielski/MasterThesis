package com.mt.claimportaljava.utils.model;

import com.mt.claimportaljava.dtos.CreateClaimDto;
import com.mt.claimportaljava.models.Claim;
import com.mt.claimportaljava.models.Contact;
import com.mt.claimportaljava.models.Location;
import com.mt.claimportaljava.models.Policy;
import com.mt.claimportaljava.utils.ClaimNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClaimBuilder {
    private Claim claim;

    private ClaimNumberGenerator claimNumberGenerator;

    public ClaimBuilder() {
        this.claim = new Claim();
    }

    @Autowired
    public void setClaimNumberGenerator(ClaimNumberGenerator claimNumberGenerator) {
        this.claimNumberGenerator = claimNumberGenerator;
    }

    public void withDataFromDto(CreateClaimDto createClaimDto) {
        PolicyBuilder policyBuilder = new PolicyBuilder();
        policyBuilder.withDataFromDto(createClaimDto.getPolicy());

        ContactBuilder reporterBuilder = new ContactBuilder();
        reporterBuilder.withDataFromDto(createClaimDto.getReporter());

        ContactBuilder claimantBuilder = new ContactBuilder();
        claimantBuilder.withDataFromDto(createClaimDto.getClaimant());

        LocationBuilder lossLocationBuilder = new LocationBuilder();
        lossLocationBuilder.withDataFromDto(createClaimDto.getLossLocation());

        withClaimNumber(claimNumberGenerator.generateClaimNumber());
        withDescription(createClaimDto.getDescription());
        withPolicy(policyBuilder.build());
        withLossLocation(lossLocationBuilder.build());
        withLossDate(createClaimDto.getLossDate());
        withReporter(reporterBuilder.build());
        withClaimant(claimantBuilder.build());
    }

    public Claim build() {
        return this.claim;
    }

    public void withClaimNumber(String claimNumber) {
        this.claim.setClaimNumber(claimNumber);
    }

    public void withDescription(String description) {
        this.claim.setDescription(description);
    }

    public void withPolicy(Policy policy) {
        this.claim.setPolicy(policy);
    }

    public void withLossLocation(Location lossLocation) {
        this.claim.setLossLocation(lossLocation);
    }

    public void withLossDate(Date lossDate) {
        this.claim.setLossDate(lossDate);
    }

    public void withReporter(Contact reporter) {
        this.claim.setReporter(reporter);
    }

    public void withClaimant(Contact claimant) {
        this.claim.setClaimant(claimant);
    }
}
