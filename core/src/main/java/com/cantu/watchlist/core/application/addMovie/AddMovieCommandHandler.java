package com.cantu.watchlist.core.application.addMovie;

import com.cantu.watchlist.core.domain.MovieBuilder;
import com.cantu.watchlist.core.domain.MovieRepository;
import com.cantu.watchlist.infrastructure.CommandHandler;

public class AddMovieCommandHandler implements CommandHandler<AddMovieCommand> {

    private final MovieRepository movieRepository;

    public AddMovieCommandHandler(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void handle(AddMovieCommand command) {
        movieRepository.save(
                MovieBuilder
                        .aMovieBuilder()
                        .withName(command.getName())
                        .withMovieId(command.getImdb())
                        .build()
        );
    }
}
