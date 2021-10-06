package com.cantu.watchlist.core.domain;

public class MovieIdBuilder {
    private String imdb;

    private MovieIdBuilder() {
    }

    public static MovieIdBuilder aMovieIdBuilder() {
        return new MovieIdBuilder();
    }

    public MovieIdBuilder withImdb(String imdb) {
        this.imdb = imdb;
        return this;
    }

    public MovieId build() {
        return new MovieId(imdb);
    }
}