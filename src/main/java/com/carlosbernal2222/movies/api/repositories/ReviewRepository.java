package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {


}
