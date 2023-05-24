package com.meetup.grafana.api;

import com.meetup.grafana.model.ImageDTO;
import com.meetup.grafana.model.ManufacturerDTO;
import com.meetup.grafana.model.ProductDTO;
import com.meetup.grafana.model.StockDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final WebClient webClient;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
        log.info("getProduct called -> productId: {}", productId);
        List<ImageDTO> imageDTOList = webClient.get()
                .uri("http://localhost:8080/api/images/" + productId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ImageDTO>>() {
                }).block();
        StockDTO stockDTO = webClient.get()
                .uri("http://localhost:8080/api/stocks/" + productId)
                .retrieve()
                .bodyToMono(StockDTO.class).block();

        long manufacturerId = new Random().nextLong(1,1000);

        if (manufacturerId>700) {
            log.warn("Manufacturer id is greater than 700 : {} ", manufacturerId);
        } else if (manufacturerId>500){
            log.error("Manufacturer id is greater than 500 : {} ", manufacturerId);
        } else {
            log.debug("Manufacturer id is less than 500: {} ", manufacturerId);
        }

        ManufacturerDTO manufacturerDTO = webClient.get()
                .uri("http://localhost:8080/api/manufacturers/" + manufacturerId)
                .retrieve()
                .bodyToMono(ManufacturerDTO.class).block();
        ProductDTO productDTO = ProductDTO.builder()
                .productId(productId)
                .images(imageDTOList)
                .stock(stockDTO)
                .manufacturer(manufacturerDTO)
                .description("Description " + productId)
                .name("Product " + productId)
                .build();
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


}
