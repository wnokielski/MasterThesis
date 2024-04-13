package com.mt.claimportaljava.services;

import com.mt.claimportaljava.dtos.CreateClaimDto;
import com.mt.claimportaljava.models.Claim;
import com.mt.claimportaljava.repositories.ClaimRepository;
import com.mt.claimportaljava.utils.model.ClaimBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service
public class ClaimService {
    private ClaimRepository claimRepository;
    private ClaimBuilder claimBuilder;

    @Autowired
    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Autowired
    public void setClaimBuilder(ClaimBuilder claimBuilder) {
        this.claimBuilder = claimBuilder;
    }

    public Claim getClaimByClaimNumber(String claimNumber) {
        return claimRepository.findClaimByClaimNumber(claimNumber);
    }

    public String createClaim(CreateClaimDto createClaimDto) {
        claimBuilder.withDataFromDto(createClaimDto);
        Claim claim = claimBuilder.build();
        claimRepository.save(claim);
        return claim.getClaimNumber();
    }

    public void updateClaim(String claimNumber, Map<String, Object> fields) {
        Claim claim = claimRepository.findClaimByClaimNumber(claimNumber);
        if (fields.containsKey("description")) {
            claim.setDescription((String) fields.get("description"));
        }
        if (fields.containsKey("lossDate")) {
            claim.setLossDate((Date) fields.get("lossDate"));
        }
        claimRepository.save(claim);
    }

    @Transactional
    public void deleteClaim(String claimNumber) {
        claimRepository.deleteByClaimNumber(claimNumber);
    }

}
