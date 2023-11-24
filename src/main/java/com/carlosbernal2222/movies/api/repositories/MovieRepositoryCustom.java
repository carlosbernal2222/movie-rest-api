package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Movie;

import java.util.List;

public interface MovieRepositoryCustom {
    List<Movie> findByCriteria(String genre, String releaseDate);
}
