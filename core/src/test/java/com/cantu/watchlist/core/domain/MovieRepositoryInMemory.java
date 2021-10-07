package com.cantu.watchlist.core.domain;

import com.cantu.ddd.framework.domain.EntityId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieRepositoryInMemory implements MovieRepository {

    private final Map<EntityId, Movie> movies;

    public MovieRepositoryInMemory() {
        movies = new HashMap<>();
    }

    @Override
    public Movie save(Movie entity) {
        movies.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Movie findById(EntityId id) {
        return movies.get(id);
    }

    @Override
    public List<Movie> findAll() {
        return movies.values().stream().collect(Collectors.toList());
    }
}
