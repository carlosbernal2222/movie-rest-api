package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

//    automatic queries

    //Finds all movies by imdbId
    Optional<Movie> findMovieByImdbId(String imdbId);

}
