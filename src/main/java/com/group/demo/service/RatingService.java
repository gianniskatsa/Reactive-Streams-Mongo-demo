package com.group.demo.service;

import com.group.demo.domain.Establishment;
import com.group.demo.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public Flux<Establishment> getAll() {
        return ratingRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Establishment> getById(final String id) {
        return ratingRepository.findById(id);
    }

    public Mono<Establishment> update(final String id, final Establishment establishment) {
        return ratingRepository.save(establishment);
    }

    public Establishment save(final Establishment establishment) {
        ratingRepository.save(establishment).subscribe();
        return establishment;
    }

    public Mono<Establishment> delete(final String id) {
        final Mono<Establishment> establishment = getById(id);
        if (Objects.isNull(establishment)) {
            return Mono.empty();
        }
        return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(establishmentToBeDeleted -> ratingRepository
                .delete(establishmentToBeDeleted).then(Mono.just(establishmentToBeDeleted)));
    }
}
