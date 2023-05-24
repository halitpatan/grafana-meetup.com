package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CountryDTO {
    private Long countryId;
    private String name;
}
