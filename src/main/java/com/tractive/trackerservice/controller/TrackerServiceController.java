package com.tractive.trackerservice.controller;

import com.tractive.trackerservice.dto.PetsOutSideZoneDetails;
import com.tractive.trackerservice.model.db.PetModel;
import com.tractive.trackerservice.service.PetDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class TrackerServiceController {

    private final PetDetailsService petDetailsService;

    private static final String GET_PET_DETAILS = "v1/tracker/pet-details/{ownerId}";
    private static final String GET_PETS_OUTSIDE_POWER_SAVING = "v1/tracker/pets-outside-zone";

    @GetMapping(GET_PET_DETAILS)
    public ResponseEntity<PetModel> getPetDetailsByOwnerId(@PathVariable(value = "ownerId") Integer ownerId) {

        log.info("Request received for pet ownerId {}", ownerId);
        PetModel response = petDetailsService.getPetDetailsForOwnerId(ownerId);

        return ResponseEntity.ok(response);
    }

    @GetMapping(GET_PETS_OUTSIDE_POWER_SAVING)
    public ResponseEntity<List<PetsOutSideZoneDetails>> getPetsOutsideOfPowerSavingMode() {

        log.info("Request received to fetch pets outside power saving mode");
        List<PetsOutSideZoneDetails> petsOutSideDetailsList = petDetailsService.getPetsOutSideOfPowerSavingZone();

        return ResponseEntity.ok(petsOutSideDetailsList);
    }

}
