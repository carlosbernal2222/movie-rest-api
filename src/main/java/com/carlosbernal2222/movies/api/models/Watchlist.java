package com.carlosbernal2222.movies.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "watchlist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Watchlist {

    @Id
    private ObjectId id;
    private String userId;
    private List<String> movieIds;

    public <E> Watchlist(String userId, ArrayList<E> es) {
    }
}
