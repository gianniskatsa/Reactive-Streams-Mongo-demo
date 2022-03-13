package com.group.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentValueDto {

    @JsonProperty("RatingValue")
    private String ratingValue;

    @JsonProperty("LocalAuthorityBusinessID")
    private String establishmentId;

    @JsonProperty("AddressLine2")
    private String name;

    @JsonProperty("LocalAuthorityName")
    private String city;
}
