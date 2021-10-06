package com.cantu.watchlist.core.application;

import com.cantu.watchlist.infrastructure.Command;

public class CreateMovieCommand implements Command {

    private final String name;
    private final String imdb;

    public CreateMovieCommand(final String name, final String imdb) {
        this.name = name;
        this.imdb = imdb;
    }

    public String getName() {
        return name;
    }

    public String getImdb() {
        return imdb;
    }
}
