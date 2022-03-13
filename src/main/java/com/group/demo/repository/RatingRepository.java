package com.group.demo.repository;

import com.group.demo.domain.Establishment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends ReactiveMongoRepository<Establishment, String> {
}
