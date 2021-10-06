package com.cantu.watchlist.adapter.rest.dto;

public class AddMovieRequestBody {

    private String imdb;
    private String movie;

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
