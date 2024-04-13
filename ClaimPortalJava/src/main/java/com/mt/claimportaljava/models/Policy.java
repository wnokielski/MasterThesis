package com.mt.claimportaljava.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue
    private Long id;

    private String policyNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyholder_id", referencedColumnName = "id")
    private Contact policyHolder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insured_id", referencedColumnName = "id")
    private Contact insured;

    private Date effectiveDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Contact getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(Contact policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Contact getInsured() {
        return insured;
    }

    public void setInsured(Contact insured) {
        this.insured = insured;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
