package com.carlosbernal2222.movies.api.services;

import com.carlosbernal2222.movies.api.models.Watchlist;
import com.carlosbernal2222.movies.api.repositories.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    public Watchlist getWatchlistByUserId(String userId) {
        return watchlistRepository.findByUserId(userId).orElse(new Watchlist());
    }

    public Watchlist addMovieToWatchlist(String userId, String movieId) {
        Watchlist watchlist = watchlistRepository.findByUserId(userId)
                .orElse(new Watchlist(userId)); // Use the modified constructor

        if (!watchlist.getMovieIds().contains(movieId)) {
            watchlist.getMovieIds().add(movieId);
            watchlistRepository.save(watchlist);
        }

        return watchlist;
    }

    public Watchlist removeMovieFromWatchlist(String userId, String movieId) {
        Watchlist watchlist = watchlistRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Watchlist newWatchlist = new Watchlist();
                    newWatchlist.setUserId(userId);
                    newWatchlist.setMovieIds(new ArrayList<>());
                    return newWatchlist;
                });

        watchlist.getMovieIds().remove(movieId); // Remove the movie ID
        watchlistRepository.save(watchlist); // Save the updated watchlist

        return watchlist;
    }
}
