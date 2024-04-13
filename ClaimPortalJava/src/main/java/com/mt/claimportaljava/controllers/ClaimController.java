package com.mt.claimportaljava.controllers;

import com.mt.claimportaljava.dtos.CreateClaimDto;
import com.mt.claimportaljava.models.Claim;
import com.mt.claimportaljava.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/byClaimNumber/{claimNumber}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Claim getClaim(@PathVariable String claimNumber) {
        return claimService.getClaimByClaimNumber(claimNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createClaim(@RequestBody CreateClaimDto createClaimDto) {
        return claimService.createClaim(createClaimDto);
    }

    @PatchMapping("/byClaimNumber/{claimNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void updateClaim(@PathVariable String claimNumber, @RequestBody Map<String, Object> fields) {
        claimService.updateClaim(claimNumber, fields);
    }

    @DeleteMapping("/byClaimNumber/{claimNumber}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void deleteClaim(@PathVariable String claimNumber) {
        claimService.deleteClaim(claimNumber);
    }

}