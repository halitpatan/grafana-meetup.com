package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ImageDTO {
    private Long productId;
    private Long imageId;
    private String filename;
    private String imagePath;
}
