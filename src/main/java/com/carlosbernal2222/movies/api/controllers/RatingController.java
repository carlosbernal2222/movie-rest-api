package com.carlosbernal2222.movies.api.controllers;

import com.carlosbernal2222.movies.api.models.Rating;
import com.carlosbernal2222.movies.api.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ratings")
@CrossOrigin("http://localhost:3000")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<?> addRating(@RequestParam String movieId,
                                       @RequestParam String userId,
                                       @RequestParam double score) {
        try {
            Rating rating = ratingService.addRating(movieId, userId, score);
            return ResponseEntity.ok(rating);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Other endpoints
}
