package com.tractive.trackerservice.model.db;

import com.tractive.trackerservice.dto.PetType;
import com.tractive.trackerservice.dto.TrackerType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetsOutSideZone {

    private PetType petType;
    private TrackerType trackerType;
    private Long count;

}
