package com.tractive.trackerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetType {

    CAT("Cat"),
    DOG("Dog");

    private final String value;

}
