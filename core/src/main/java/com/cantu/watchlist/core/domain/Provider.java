package com.cantu.watchlist.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Provider implements Entity<String> {

    private final ProviderName name;
    private final List<Movie> availableMovies;

    protected Provider(final ProviderName name) {
        this.name = name;
        this.availableMovies = new ArrayList<>();
    }

    public void addMovie(final Movie movie) {
        availableMovies.add(movie);
    }

    public List<Movie> getAvailableMovies() {
        return Collections.unmodifiableList(availableMovies);
    }

    @Override
    public String getId() {
        return name.get();
    }
}
