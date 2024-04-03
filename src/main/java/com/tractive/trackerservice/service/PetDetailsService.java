package com.tractive.trackerservice.service;

import com.tractive.trackerservice.model.PetDetails;
import com.tractive.trackerservice.model.PetsOutSideZoneDetails;
import com.tractive.trackerservice.model.db.PetModel;

import java.util.List;

public interface PetDetailsService {

    void savePetDetails(PetDetails petDetails);
    PetModel getPetDetailsForOwnerId(Integer ownerId);

    List<PetsOutSideZoneDetails> getPetsOutSideOfPowerSavingZone();
}
