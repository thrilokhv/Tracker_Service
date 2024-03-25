package com.tractive.trackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
public class TrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerServiceApplication.class, args);
	}

}
