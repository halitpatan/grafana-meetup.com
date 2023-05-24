package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class StockDTO {
    private Long productId;
    private Integer quantity;
}
