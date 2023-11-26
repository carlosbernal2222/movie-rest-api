package com.carlosbernal2222.movies.api.repositories;

import com.carlosbernal2222.movies.api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
