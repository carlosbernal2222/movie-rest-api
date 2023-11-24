package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Movie;
import com.carlosbernal2222.movies.api.repositories.MovieRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MovieRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Movie> findByCriteria(String genre, String releaseDate) {
        Query query = new Query();
        if (genre != null) {
            query.addCriteria(Criteria.where("genres").is(genre));
        }
        if (releaseDate != null) {
            query.addCriteria(Criteria.where("releaseDate").is(releaseDate));
        }

        return mongoTemplate.find(query, Movie.class);
    }
}
