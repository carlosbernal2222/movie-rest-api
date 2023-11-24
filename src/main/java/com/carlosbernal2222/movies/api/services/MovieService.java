package com.carlosbernal2222.movies.api.services;

import com.carlosbernal2222.movies.api.models.Movie;
import com.carlosbernal2222.movies.api.repositories.MovieRepository;
import com.carlosbernal2222.movies.api.repositories.MovieRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @Autowired
    private MovieRepositoryCustom movieRepositoryCustom;

    public List<Movie> advancedSearch(String genre, String releaseDate) {
        List<Movie> movies = movieRepositoryCustom.findByCriteria(genre, releaseDate);

        return movies;
    }

}
