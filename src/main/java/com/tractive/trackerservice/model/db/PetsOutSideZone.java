package com.tractive.trackerservice.model.db;

import com.tractive.trackerservice.model.PetType;
import com.tractive.trackerservice.model.TrackerType;
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
