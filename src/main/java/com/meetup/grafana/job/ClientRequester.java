package com.meetup.grafana.job;

import com.meetup.grafana.model.ProductDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientRequester {
    private final WebClient webClient;

    @Scheduled(fixedRate = 5,timeUnit = TimeUnit.SECONDS)
    public void execute() {
        Long productId = new Random().nextLong(1, 1000);
        log.info(">>>>>>>>>Client request executed -> productId: {}, executionTime: {}", productId, LocalDateTime.now());

        ProductDTO productDTO= webClient.get()
                .uri("http://localhost:8080/api/products/"+productId)
                .retrieve()
                .bodyToMono(ProductDTO.class).block();

        log.info("<<<<<<<<<Client request completed -> product: {}",productDTO);
    }

}
