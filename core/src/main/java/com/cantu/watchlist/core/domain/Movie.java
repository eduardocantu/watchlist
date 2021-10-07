package com.cantu.watchlist.core.domain;

import com.cantu.ddd.framework.domain.Entity;

import java.util.Objects;

public class Movie implements Entity<MovieId> {

    private final MovieId movieId;
    private final String name;

    protected Movie(final String name, final MovieId movieId) {
        this.name = name;
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return movieId.equals(movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public MovieId getId() {
        return movieId;
    }

    public String getName() {
        return name;
    }
}
