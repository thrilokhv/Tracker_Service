package com.tractive.trackerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PetsOutSideZoneDetails {

    private PetType petType;
    private TrackerType trackerType;
    private Long count;

}
