package com.carlosbernal2222.movies.api.controllers;

import com.carlosbernal2222.movies.api.models.Watchlist;
import com.carlosbernal2222.movies.api.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/watchlist")
@CrossOrigin("http://localhost:3000")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @GetMapping("/{userId}")
    public ResponseEntity<Watchlist> getWatchlist(@PathVariable String userId) {
        Watchlist watchlist = watchlistService.getWatchlistByUserId(userId);
        return ResponseEntity.ok(watchlist);
    }

    @PostMapping("/{userId}/add/{movieId}")
    public ResponseEntity<Watchlist> addMovieToWatchlist(@PathVariable String userId, @PathVariable String movieId) {
        Watchlist updatedWatchlist = watchlistService.addMovieToWatchlist(userId, movieId);
        return ResponseEntity.ok(updatedWatchlist);
    }

    // Endpoints for removing movies, etc.
}
