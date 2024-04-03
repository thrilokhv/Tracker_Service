package com.tractive.trackerservice.service.impl;

import com.tractive.trackerservice.model.PetDetails;
import com.tractive.trackerservice.model.PetsOutSideZoneDetails;
import com.tractive.trackerservice.exception.ResourceNotFoundException;
import com.tractive.trackerservice.jpa.repository.PetDetailsRepository;
import com.tractive.trackerservice.model.db.PetModel;
import com.tractive.trackerservice.model.db.PetsOutSideZone;
import com.tractive.trackerservice.service.PetDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PetDetailsServiceImpl implements PetDetailsService {

    private PetDetailsRepository petDetailsRepository;
    @Override
    public void savePetDetails(PetDetails petDetails) {

        petDetailsRepository.save(PetModel.builder().ownerId(petDetails.getOwnerId())
                .petType(petDetails.getPetType())
                .trackerType(petDetails.getTrackerType())
                .inZone(petDetails.getInZone())
                .lostTracker(petDetails.getLostTracker()).build());
    }

    @Override
    public PetModel getPetDetailsForOwnerId(Integer ownerId) {

        Optional<PetModel> petDetailsResponse = petDetailsRepository.findByOwnerId(ownerId);

        return petDetailsResponse.orElseThrow(() -> new ResourceNotFoundException(String
                .format("Owner not found fot the account: %s", ownerId)));
    }

    @Override
    public List<PetsOutSideZoneDetails> getPetsOutSideOfPowerSavingZone() {

        Optional<List<PetsOutSideZone>> inZoneResponse = petDetailsRepository
                .findPetsOutsidePowerSavingZoneGroupedByPetTypeAndTrackerType();

        if(inZoneResponse.isPresent()) {
            return inZoneResponse.get()
                    .stream().map(this::getPetsOutSideDetails).toList();
        } else {
             throw new ResourceNotFoundException("No Pets found Outside of Power Saving Zone");
        }
    }

    public PetsOutSideZoneDetails getPetsOutSideDetails(PetsOutSideZone petsOutSideZone) {

        return PetsOutSideZoneDetails.builder().petType(petsOutSideZone.getPetType())
                .trackerType(petsOutSideZone.getTrackerType()).count(petsOutSideZone.getCount()).build();

    }
}
