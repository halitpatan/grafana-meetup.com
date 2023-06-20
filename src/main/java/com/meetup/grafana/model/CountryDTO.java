package com.meetup.grafana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CountryDTO {
    private Long countryId;
    private String name;
}
