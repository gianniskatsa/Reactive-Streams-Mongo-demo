package com.group.demo.controller;

import com.group.demo.converter.EstablishmentConverter;
import com.group.demo.domain.Establishment;
import com.group.demo.dto.EstablishmentDto;
import com.group.demo.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class RatingController {
    private final RestTemplate restTemplate;
    private final EstablishmentConverter establishmentConverter;
    private final RatingService ratingService;

    @RequestMapping(value = "/{cityId}/{pagesize}", produces = "application/json")
    public List<Establishment> getDataFromUK(@PathVariable("cityId") Integer cityId, @PathVariable("pagesize") Integer pagesize) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-version", "2");
        HttpEntity<EstablishmentDto> entity = new HttpEntity<>(headers);

        EstablishmentDto establishmentsDto = restTemplate.exchange(
                "http://api.ratings.food.gov.uk/Establishments?localAuthorityId={cityId}&pagesize={pagesize}",
                HttpMethod.GET,
                entity,
                EstablishmentDto.class,
                cityId,
                pagesize).getBody();

        return establishmentsDto.getEstablishments().stream()
                .map(establishmentConverter::convertEstablishmentDto)
                .map(ratingService::save)
                .toList();
    }

    @GetMapping
    Flux<Establishment> getAll() {
        log.info("Getting all establishments");
        return ratingService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Establishment> getById(@PathVariable("id") final String id) {
        log.info("Getting establishment with id: " + id);
        return ratingService.getById(id);
    }

    @PutMapping("{id}")
    public Mono<Establishment> updateById(@PathVariable("id") final String id, @RequestBody final Establishment student) {
        log.info("Updating establishment with id: " + id);
        return ratingService.update(id, student);
    }

    @DeleteMapping("{id}")
    public Mono<Establishment> delete(@PathVariable final String id) {
        log.info("Deleting establishment with id: " + id);
        return ratingService.delete(id);
    }

}
