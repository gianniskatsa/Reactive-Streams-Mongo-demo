package com.group.demo.converter;

import com.group.demo.domain.Establishment;
import com.group.demo.dto.EstablishmentValueDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EstablishmentConverter {

    public Establishment convertEstablishmentDto(EstablishmentValueDto valueDto) {
        return Establishment.builder()
                .establishmentId(valueDto.getEstablishmentId())
                .city(valueDto.getCity())
                .name(valueDto.getName())
                .ratingValue(valueDto.getRatingValue())
                .build();
    }
}
