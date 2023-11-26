package com.carlosbernal2222.movies.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    private String id;
    private String movieId;
    private String userId;
    private double score; // Rating score, e.g., 1 to 5

}
