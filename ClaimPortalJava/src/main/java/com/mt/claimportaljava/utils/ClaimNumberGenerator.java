package com.mt.claimportaljava.utils;

import com.mt.claimportaljava.repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimNumberGenerator {
    private ClaimRepository claimRepository;

    @Autowired
    public void setClaimRepository(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public String generateClaimNumber() {
        long nextSequenceNumber = claimRepository.count() + 1;
        String number = String.valueOf(nextSequenceNumber);
        while (number.length() < 9) {
            number = "0" + number;
        }
        String claimNumber = "CL" + number;
        return claimNumber;
    }
}
