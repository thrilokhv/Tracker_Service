package com.tractive.trackerservice.service;

import com.tractive.trackerservice.dto.PetDetails;
import com.tractive.trackerservice.dto.PetsOutSideZoneDetails;
import com.tractive.trackerservice.model.db.PetModel;

import java.util.List;

public interface PetDetailsService {

    void savePetDetails(PetDetails petDetails);
    PetModel getPetDetailsForOwnerId(Integer ownerId);

    List<PetsOutSideZoneDetails> getPetsOutSideOfPowerSavingZone();
}
