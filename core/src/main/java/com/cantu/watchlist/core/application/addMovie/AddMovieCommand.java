package com.cantu.watchlist.core.application.addMovie;

import com.cantu.watchlist.infrastructure.Command;

public class AddMovieCommand implements Command {

    private final String name;
    private final String imdb;

    public AddMovieCommand(final String name, final String imdb) {
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
