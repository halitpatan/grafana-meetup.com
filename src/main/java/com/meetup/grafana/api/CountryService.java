package com.meetup.grafana.api;

import com.meetup.grafana.model.CountryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
@Slf4j
public class CountryService {

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Long countryId) throws InterruptedException {
        log.info("getCountry called -> countryId: {}", countryId);
        long sleepTime = new Random().nextLong(5000, 10000);
        Thread.sleep(sleepTime);
        return new ResponseEntity<>(CountryDTO.builder()
                .countryId(countryId)
                .name("Country " + countryId)
                .build(), HttpStatus.OK);
    }
}
