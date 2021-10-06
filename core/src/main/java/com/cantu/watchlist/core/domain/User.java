package com.cantu.watchlist.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class User {

    private String name;
    private List<Movie> watchList;
    private List<Provider> providers;

    protected User(final String name) {
        this.name = name;
        this.watchList = new ArrayList<>();
        this.providers = new ArrayList<>();
    }

    public void subscribeToProvider(final Provider provider) {
        providers.add(provider);
    }

    public void addMovieToWatchList(final Movie wantToWatch) {
        watchList.add(wantToWatch);
    }

    public List<Movie> getWatchList() {
        return Collections.unmodifiableList(watchList);
    }

    public List<Provider> getProviders() {
        return Collections.unmodifiableList(providers);
    }
}
