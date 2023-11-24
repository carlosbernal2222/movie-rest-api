package com.carlosbernal2222.movies.api.controllers;

import com.carlosbernal2222.movies.api.models.Movie;
import com.carlosbernal2222.movies.api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping

    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        return new ResponseEntity<>(movieService.searchMovies(title), HttpStatus.OK);
    }

    @GetMapping("/advanced-search")
    public ResponseEntity<List<Movie>> advancedSearch(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String releaseDate) {
        List<Movie> movies = movieService.advancedSearch(genre, releaseDate);
        return ResponseEntity.ok(movies);
    }
}
