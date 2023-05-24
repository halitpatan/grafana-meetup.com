package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private ManufacturerDTO manufacturer;
    private List<ImageDTO> images;
    private StockDTO stock;
}
