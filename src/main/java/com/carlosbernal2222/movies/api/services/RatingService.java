package com.carlosbernal2222.movies.api.services;

import com.carlosbernal2222.movies.api.models.Movie;
import com.carlosbernal2222.movies.api.models.Rating;
import com.carlosbernal2222.movies.api.repositories.MovieRepository;
import com.carlosbernal2222.movies.api.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Rating addRating(String movieId, String userId, double score) {
        // Check if the user has already rated this movie
        Optional<Rating> existingRating = ratingRepository.findByMovieIdAndUserId(movieId, userId);

        if (existingRating.isPresent()) {
            // User has already rated this movie
            throw new RuntimeException("User has already rated this movie.");
        } else {
            // Add new rating
            Rating rating = new Rating();
            rating.setMovieId(movieId);
            rating.setUserId(userId);
            rating.setScore(score);
            ratingRepository.save(rating);

            // Update movie rating
            updateMovieRating(movieId);

            return rating;
        }
    }


    private void updateMovieRating(String movieId) {
        try {
            // Find all ratings for the given movie
            List<Rating> ratings = ratingRepository.findByMovieId(movieId);

            // Calculate the average rating
            double average = ratings.stream()
                    .mapToDouble(Rating::getScore)
                    .average()
                    .orElse(0.0);

            // Get the total number of ratings
            int totalRatings = ratings.size();

            // Find the movie and update its average rating and rating count
            Optional<Movie> movieOptional = movieRepository.findMovieByImdbId(movieId);
            if (movieOptional.isPresent()) {
                Movie movie = movieOptional.get();
                movie.setAverageRating(average);
                movie.setRatingCount(totalRatings);
                movieRepository.save(movie);
            } else {
                // Handle the case where the movie is not found
                throw new RuntimeException("Movie not found with ID: " + movieId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating movie rating for movie ID: " + movieId, e);
        }
    }


}
