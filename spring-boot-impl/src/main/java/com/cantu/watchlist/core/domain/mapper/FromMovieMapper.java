package com.cantu.watchlist.core.domain.mapper;

import com.cantu.watchlist.core.domain.Movie;
import com.cantu.watchlist.core.domain.MovieJPA;

import java.util.function.Function;

public class FromMovieMapper implements Function<Movie, MovieJPA> {
    @Override
    public MovieJPA apply(Movie movie) {
        return new MovieJPA(
                movie.getId().get(),
                movie.getName()
        );
    }
}
