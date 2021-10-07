package com.cantu.watchlist.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Provider implements Entity<ProviderName> {

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
    public ProviderName getId() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;
        Provider provider = (Provider) o;
        return name.equals(provider.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
