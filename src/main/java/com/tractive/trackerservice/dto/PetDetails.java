package com.tractive.trackerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PetDetails {

    private Integer ownerId;
    private PetType petType;
    private TrackerType trackerType;
    private Boolean inZone;
    private Boolean lostTracker;
}
