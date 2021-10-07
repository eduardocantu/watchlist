package com.cantu.watchlist.at.dto;

import java.io.Serializable;

public class Movie implements Serializable {

    final String movie;
    final String imdb;

    public Movie(String movie, String imdb) {
        this.movie = movie;
        this.imdb = imdb;
    }
}
