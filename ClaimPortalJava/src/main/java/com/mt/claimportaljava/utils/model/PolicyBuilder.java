package com.mt.claimportaljava.utils.model;

import com.mt.claimportaljava.dtos.CreatePolicyDto;
import com.mt.claimportaljava.models.Contact;
import com.mt.claimportaljava.models.Policy;

import java.util.Date;

public class PolicyBuilder {
    private Policy policy;

    public PolicyBuilder() {
        this.policy = new Policy();
    }

    public Policy build() {
        return this.policy;
    }

    public void withDataFromDto(CreatePolicyDto createPolicyDto) {
        ContactBuilder insuredBuilder = new ContactBuilder();
        insuredBuilder.withDataFromDto(createPolicyDto.getInsured());

        ContactBuilder policyHolderBuilder = new ContactBuilder();
        policyHolderBuilder.withDataFromDto(createPolicyDto.getPolicyHolder());

        this.withPolicyNumber(createPolicyDto.getPolicyNumber());
        this.withPolicyHolder(policyHolderBuilder.build());
        this.withInsured(insuredBuilder.build());
        this.withEffectiveDate(createPolicyDto.getEffectiveDate());
    }

    public void withPolicyNumber(String policyNumber) {
        this.policy.setPolicyNumber(policyNumber);
    }

    public void withPolicyHolder(Contact policyHolder) {
        this.policy.setPolicyHolder(policyHolder);
    }

    public void withInsured(Contact insured) {
        this.policy.setInsured(insured);
    }

    public void withEffectiveDate(Date effectiveDate) {
        this.policy.setEffectiveDate(effectiveDate);
    }
}
