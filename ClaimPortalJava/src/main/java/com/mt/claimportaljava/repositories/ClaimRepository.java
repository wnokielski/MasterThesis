package com.mt.claimportaljava.repositories;

import com.mt.claimportaljava.models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    Claim findClaimByClaimNumber(String claimNumber);

    void deleteById(long id);

    void deleteByClaimNumber(String claimNumber);
}
