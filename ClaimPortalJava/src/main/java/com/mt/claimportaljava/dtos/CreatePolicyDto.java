package com.mt.claimportaljava.dtos;

import java.util.Date;

public class CreatePolicyDto {
    private String policyNumber;
    private CreateContactDto policyHolder;
    private CreateContactDto insured;
    private Date effectiveDate;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public CreateContactDto getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(CreateContactDto policyHolder) {
        this.policyHolder = policyHolder;
    }

    public CreateContactDto getInsured() {
        return insured;
    }

    public void setInsured(CreateContactDto insured) {
        this.insured = insured;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
