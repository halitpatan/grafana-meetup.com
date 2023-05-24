package com.meetup.grafana.job;

import com.meetup.grafana.model.CountryDTO;
import com.meetup.grafana.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class JobExecutor {

    private final WebClient webClient;

    //@Scheduled(fixedRate = 30000)
    public void execute() {
        Long productId = new Random().nextLong(1,1000);

        log.info("JobExecutor initialized -> productId: {}, executionTime: {}",productId,LocalDateTime.now());

        ProductDTO productDTO= webClient.get()
                .uri("http://localhost:8080/api/products/"+productId)
                .retrieve()
                .bodyToMono(ProductDTO.class).block();

        log.info("JobExecutor completed -> productDTO: {}",productDTO);

    }

}
