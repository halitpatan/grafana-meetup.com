package com.meetup.grafana.api;

import com.meetup.grafana.model.StockDTO;
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
@RequestMapping("/stocks")
@RequiredArgsConstructor
@Slf4j
public class StockService {
    @GetMapping("/{productId}")
    public ResponseEntity<StockDTO> getStock(@PathVariable Long productId) {
        log.info("getStock called -> productId: {}", productId);
        return new ResponseEntity<>(StockDTO.builder().productId(productId).quantity(new Random().nextInt(1,1000)).build(), HttpStatus.OK);
    }
}
