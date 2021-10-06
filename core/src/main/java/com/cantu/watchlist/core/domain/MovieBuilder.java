package com.cantu.watchlist.core.domain;

public class MovieBuilder {
    private String movieId;
    private String name;

    private MovieBuilder() {
    }

    public static MovieBuilder aMovieBuilder() {
        return new MovieBuilder();
    }

    public MovieBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder withMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public Movie build() {
        return new Movie(name,
                MovieIdBuilder
                        .aMovieIdBuilder()
                        .withImdb(movieId)
                        .build()
        );
    }
}