package com.cantu.watchlist.core.domain;

import java.util.Objects;

public class MovieId implements EntityId<String> {

    private final String imdb;

    protected MovieId(final String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String get() {
        return this.imdb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieId)) return false;
        MovieId movieId = (MovieId) o;
        return imdb.equals(movieId.imdb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdb);
    }
}