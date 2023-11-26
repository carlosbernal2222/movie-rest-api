package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
