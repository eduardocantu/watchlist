package com.cantu.watchlist.adapter.rest.dto;

public class AddMovieResponseBody {
    private final String imdb;
    private final String movie;

    public AddMovieResponseBody(String imdb, String movie) {
        this.imdb = imdb;
        this.movie = movie;
    }

    public String getImdb() {
        return imdb;
    }

    public String getMovie() {
        return movie;
    }
}
