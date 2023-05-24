package com.meetup.grafana.api;

import com.meetup.grafana.model.ImageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
@Slf4j
public class ImageService {
    @GetMapping("/{productId}")
    public ResponseEntity<List<ImageDTO>> getImages(@PathVariable Long productId) {
        log.info("getImages called -> productId: {}", productId);
        List<ImageDTO> imageDTOList = new ArrayList<>();
        Stream.iterate(1, i -> i + 1)
                .limit(4)
                .forEach(i -> imageDTOList.add(ImageDTO.builder()
                        .imageId(Long.valueOf(i))
                        .filename("image" + i)
                        .imagePath("path" + i)
                        .productId(productId)
                        .build()));
        return new ResponseEntity<>(imageDTOList, HttpStatus.OK);
    }
}
