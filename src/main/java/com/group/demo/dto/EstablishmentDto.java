package com.group.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentDto {

    @NotNull
    @JsonProperty("establishments")
    List<EstablishmentValueDto> establishments;
}
