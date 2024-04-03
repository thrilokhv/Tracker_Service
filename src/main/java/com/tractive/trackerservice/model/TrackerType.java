package com.tractive.trackerservice.model;

import lombok.*;

@AllArgsConstructor
@Getter
public enum TrackerType {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String value;

}
