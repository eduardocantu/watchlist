package com.cantu.watchlist.core.application.addMovie;

import com.cantu.watchlist.core.domain.MovieBuilder;
import com.cantu.watchlist.core.domain.MovieRepository;
import com.cantu.watchlist.infrastructure.CommandHandler;
import com.cantu.watchlist.infrastructure.CommandResponse;

public class AddMovieCommandHandler implements CommandHandler<AddMovieCommand> {

    private final MovieRepository movieRepository;

    public AddMovieCommandHandler(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public CommandResponse handle(AddMovieCommand command) {
        return CommandResponse.withResponse(
                movieRepository.save(
                        MovieBuilder
                                .aMovieBuilder()
                                .withName(command.getName())
                                .withMovieId(command.getImdb())
                                .build()
                )
        );
    }
}
