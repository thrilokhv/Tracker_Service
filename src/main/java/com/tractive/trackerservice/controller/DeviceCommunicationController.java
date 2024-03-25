package com.tractive.trackerservice.controller;

import com.tractive.trackerservice.dto.PetDetails;
import com.tractive.trackerservice.jpa.repository.PetDetailsRepository;
import com.tractive.trackerservice.service.PetDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
public class DeviceCommunicationController {

    private static final String DEVICE_PET_DETAILS = "v1/tracker/pet-details";
    private final PetDetailsService petDetailsService;

    @PostMapping(DEVICE_PET_DETAILS)
    public ResponseEntity<Void> getPetDetailsFromDevice(@RequestBody PetDetails petDetails) {

        log.info("Saving pet details for owner id {}", petDetails.getOwnerId());
        petDetailsService.savePetDetails(petDetails);

        return ResponseEntity.ok().build();
    }
}
