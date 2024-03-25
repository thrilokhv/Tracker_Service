package com.tractive.trackerservice;

import com.tractive.trackerservice.dto.*;
import com.tractive.trackerservice.jpa.repository.PetDetailsRepository;
import com.tractive.trackerservice.model.db.PetModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TrackerServiceApplication.class)
class TrackerServiceApplicationTests {

	@Autowired
	PetDetailsRepository petDetailsRepository;
	@Autowired
	TestRestTemplate restTemplate;
	private TestClient testClient;

	@BeforeEach
	public void prepare() {
		testClient = new TestClient(restTemplate.getRestTemplate());
	}

	@AfterEach
	public void clean() {
      petDetailsRepository.deleteAll();
	}

	@Test
	void shouldSavePetDetailsFromDevice() {

		PetDetails petDetails = PetDetails.builder().ownerId(1).petType(PetType.CAT)
				.trackerType(TrackerType.SMALL)
				.inZone(true)
				.lostTracker(false)
				.build();

		ResponseEntity<?> responseEntity = testClient.getPetDetailsFromDevice(petDetails);

		Optional<PetModel> petModel =  petDetailsRepository.findByOwnerId(1);

        assertEquals(1, petModel.get().getOwnerId());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	void shouldGetPetDetailsByOwnerId() {

		PetModel petModel = PetModel.builder().petType(PetType.DOG).trackerType(TrackerType.LARGE)
				.ownerId(2).inZone(true).build();

		petDetailsRepository.save(petModel);

		ResponseEntity<PetModel> responseEntity = testClient.getPetDetailsByOwnerId(2);

		assertEquals(PetType.DOG, responseEntity.getBody().getPetType());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	void shouldRetrievePetsOutSideOfPowerSavingMode() {

		PetModel petModel1 = PetModel.builder().petType(PetType.DOG).trackerType(TrackerType.LARGE)
				.ownerId(2).inZone(false).build();
		PetModel petModel2 = PetModel.builder().petType(PetType.CAT).trackerType(TrackerType.SMALL)
				.ownerId(3).inZone(false).build();
		PetModel petModel3 = PetModel.builder().petType(PetType.CAT).trackerType(TrackerType.SMALL)
				.ownerId(4).inZone(true).build();
		PetModel petModel4 = PetModel.builder().petType(PetType.DOG).trackerType(TrackerType.LARGE)
				.ownerId(5).inZone(false).build();

		petDetailsRepository.save(petModel1);
		petDetailsRepository.save(petModel2);
		petDetailsRepository.save(petModel3);
		petDetailsRepository.save(petModel4);

		List<PetsOutSideZoneDetails> responseEntity = testClient.getPetsOutsideOfPowerSavingMode();

		assertEquals(2, responseEntity.size());

	}

}
