package com.meetup.grafana.api;

import com.meetup.grafana.model.CountryDTO;
import com.meetup.grafana.model.ManufacturerDTO;
import com.meetup.grafana.model.StockDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
@Slf4j
public class ManufacturerService {
    private final WebClient webClient;
    @GetMapping("/{manufacturerId}")
    public ResponseEntity<ManufacturerDTO> getManufacturer(@PathVariable Long manufacturerId) throws InterruptedException {
        log.info("getManufacturer called -> manufacturerId: {}", manufacturerId);

        long sleepTime = new Random().nextLong(5000, 10000);
        Thread.sleep(sleepTime);

        Long countryId = new Random().nextLong(1,1000);
        CountryDTO countryDTO = webClient.get()
                .uri("http://localhost:8080/api/countries/"+countryId)
                .retrieve()
                .bodyToMono(CountryDTO.class).block();

        ManufacturerDTO manufacturerDTO = ManufacturerDTO.builder()
                .manufacturerId(manufacturerId)
                .name("Manufacturer " + manufacturerId)
                .address("Address " + manufacturerId)
                .country(countryDTO).build();

        return new ResponseEntity<>(manufacturerDTO, HttpStatus.OK);
    }
}
