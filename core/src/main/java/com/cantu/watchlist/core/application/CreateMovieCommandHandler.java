package com.cantu.watchlist.core.application;

import com.cantu.watchlist.core.domain.MovieBuilder;
import com.cantu.watchlist.core.domain.MovieRepository;
import com.cantu.watchlist.infrastructure.CommandHandler;

public class CreateMovieCommandHandler implements CommandHandler<CreateMovieCommand> {

    private final MovieRepository movieRepository;

    public CreateMovieCommandHandler(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void handle(CreateMovieCommand command) {
        movieRepository.save(
                MovieBuilder
                        .aMovieBuilder()
                        .withName(command.getName())
                        .withMovieId(command.getImdb())
                        .build()
        );
    }
}
