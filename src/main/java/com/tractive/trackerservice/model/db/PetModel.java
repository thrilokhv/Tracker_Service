package com.tractive.trackerservice.model.db;

import com.tractive.trackerservice.dto.PetType;
import com.tractive.trackerservice.dto.TrackerType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class PetModel {

    @Id
    private Integer ownerId;
    private PetType petType;
    private TrackerType trackerType;
    private Boolean inZone;
    private Boolean lostTracker;

}
