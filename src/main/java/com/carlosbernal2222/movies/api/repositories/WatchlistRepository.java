package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Watchlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends MongoRepository<Watchlist, String> {
    Optional<Watchlist> findByUserId(String userId);
}
