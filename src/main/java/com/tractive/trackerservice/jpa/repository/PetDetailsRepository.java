package com.tractive.trackerservice.jpa.repository;

import com.tractive.trackerservice.model.db.PetModel;
import com.tractive.trackerservice.model.db.PetsOutSideZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetDetailsRepository extends JpaRepository<PetModel, Integer> {

    Optional<PetModel> findByOwnerId(Integer ownerId);

    @Query("SELECT NEW com.tractive.trackerservice.model.db.PetsOutSideZone(p.petType, p.trackerType, COUNT(p)) FROM PetModel p WHERE p.inZone = false GROUP BY p.petType, p.trackerType")
    Optional<List<PetsOutSideZone>> findPetsOutsidePowerSavingZoneGroupedByPetTypeAndTrackerType();
}
