package com.tractive.trackerservice.exception.handling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Error {

    private int errorCode;
    private HttpStatus status;
    private String message;
    private Collection<String> errors;
}
