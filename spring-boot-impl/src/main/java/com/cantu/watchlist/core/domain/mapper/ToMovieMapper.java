package com.cantu.watchlist.core.domain.mapper;

import com.cantu.watchlist.core.domain.Movie;
import com.cantu.watchlist.core.domain.MovieBuilder;
import com.cantu.watchlist.core.domain.MovieJPA;

import java.util.function.Function;

public class ToMovieMapper implements Function<MovieJPA, Movie> {
    @Override
    public Movie apply(MovieJPA movieJPA) {
        return MovieBuilder
                .aMovieBuilder()
                .withMovieId(movieJPA.getId())
                .withName(movieJPA.getName())
                .build();
    }
}
