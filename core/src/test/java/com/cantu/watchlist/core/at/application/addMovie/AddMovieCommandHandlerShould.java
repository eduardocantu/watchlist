package com.cantu.watchlist.core.at.application.addMovie;

import com.cantu.ddd.framework.command.CommandResponse;
import com.cantu.watchlist.core.application.addMovie.AddMovieCommand;
import com.cantu.watchlist.core.application.addMovie.AddMovieCommandHandler;
import com.cantu.watchlist.core.domain.MovieIdBuilder;
import com.cantu.watchlist.core.domain.MovieRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMovieCommandHandlerShould {

    @Test
    public void addANewMovieWhenCommanded() {
        final MovieRepositoryInMemory movieRepository = new MovieRepositoryInMemory();

        final AddMovieCommandHandler commandHandler = new AddMovieCommandHandler(movieRepository);

        final CommandResponse response = commandHandler.handle(
                new AddMovieCommand("Lord of the Rings", "1234")
        );

        assertEquals(
                response.getResponse(),
                movieRepository.findById(
                        MovieIdBuilder
                                .aMovieIdBuilder()
                                .withImdb("1234")
                                .build())
        );
    }
}
