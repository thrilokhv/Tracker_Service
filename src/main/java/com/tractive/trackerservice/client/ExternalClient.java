package com.tractive.trackerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "some-service", url = "${some-service.url}")
public interface ExternalClient {

    @PostMapping("v2/someClient")
    ResponseEntity<Object[]> doSomething(@RequestBody int value);
}
