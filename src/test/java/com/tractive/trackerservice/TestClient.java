package com.tractive.trackerservice;

import com.tractive.trackerservice.dto.PetDetails;
import com.tractive.trackerservice.dto.PetsOutSideZoneDetails;
import com.tractive.trackerservice.model.db.PetModel;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestClient {

    private final RestTemplate restTemplate;

    public TestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    public ResponseEntity<Void> getPetDetailsFromDevice(PetDetails petDetails) {
        return restTemplate.exchange("/v1/tracker/pet-details", HttpMethod.POST,
                new HttpEntity<>(petDetails, createHeaders()), Void.class);
    }

    public ResponseEntity<PetModel> getPetDetailsByOwnerId(Integer ownerId) {
        return restTemplate.exchange("/v1/tracker/pet-details/"+ownerId, HttpMethod.GET,
                new HttpEntity<>(createHeaders()), PetModel.class);
    }

    public List<PetsOutSideZoneDetails> getPetsOutsideOfPowerSavingMode() {
        ResponseEntity<List> response = restTemplate.exchange("/v1/tracker/pets-outside-zone", HttpMethod.GET,
                new HttpEntity<>(createHeaders()), List.class);
        return response.getBody();
    }
}
