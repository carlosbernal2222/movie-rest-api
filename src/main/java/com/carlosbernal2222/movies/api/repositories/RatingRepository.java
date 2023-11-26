package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
    // Additional query methods if needed
    List<Rating> findByMovieId(String movieId);

    Optional<Rating> findByMovieIdAndUserId(String movieId, String userId);
}

