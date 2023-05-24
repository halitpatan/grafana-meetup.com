package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ManufacturerDTO {
    private Long manufacturerId;
    private String name;
    private String address;
    private CountryDTO country;
}
