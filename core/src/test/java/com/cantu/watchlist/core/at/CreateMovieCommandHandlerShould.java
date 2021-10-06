package com.cantu.watchlist.core.at;

import com.cantu.watchlist.core.application.CreateMovieCommand;
import com.cantu.watchlist.core.application.CreateMovieCommandHandler;
import com.cantu.watchlist.core.domain.MovieBuilder;
import com.cantu.watchlist.core.domain.MovieIdBuilder;
import com.cantu.watchlist.core.domain.MovieRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMovieCommandHandlerShould {

    @Test
    public void addANewMovieWhenCommanded() {
        final MovieRepositoryInMemory movieRepository = new MovieRepositoryInMemory();

        final CreateMovieCommandHandler commandHandler = new CreateMovieCommandHandler(movieRepository);

        commandHandler.handle(
                new CreateMovieCommand("Lord of the Rings", "1234")
        );

        assertEquals(
                MovieBuilder
                        .aMovieBuilder()
                        .withName("Lord of the Rings")
                        .withMovieId("1234")
                        .build(),
                movieRepository.findById(
                        MovieIdBuilder
                                .aMovieIdBuilder()
                                .withImdb("1234")
                                .build())
        );
    }
}
