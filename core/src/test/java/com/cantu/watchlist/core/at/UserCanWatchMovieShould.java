package com.cantu.watchlist.core.at;

import com.cantu.watchlist.core.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanWatchMovieShould {

    @Test
    public void watchWantedMovieWhenAvailable() {
        Provider netflix = ProviderBuilder
                .aProviderBuilder()
                .withName("Netflix")
                .build();
        netflix.addMovie(
                MovieBuilder
                        .aMovieBuilder()
                        .withName("Memento")
                        .withMovieId("123")
                        .build()
        );

        User john = UserBuilder
                .aUserBuilder()
                .withName("John")
                .build();

        john.subscribeToProvider(netflix);
        john.addMovieToWatchList(
                MovieBuilder
                        .aMovieBuilder()
                        .withName("Memento")
                        .withMovieId("123")
                        .build()
        );

        assertTrue(
                new UserCanWatchMovie().canWatch(
                        john,
                        MovieBuilder
                                .aMovieBuilder()
                                .withName("Memento")
                                .withMovieId("123")
                                .build()
                ));

    }

    @Test
    public void notWatchWantedMovieWhenNotAvailable() {
        Provider netflix = ProviderBuilder
                .aProviderBuilder()
                .withName("Netflix")
                .build();
        netflix.addMovie(
                MovieBuilder
                        .aMovieBuilder()
                        .withName("Pulp Fiction")
                        .withMovieId("124")
                        .build()
        );

        User john = UserBuilder
                .aUserBuilder()
                .withName("John")
                .build();

        john.subscribeToProvider(netflix);
        john.addMovieToWatchList(
                MovieBuilder
                        .aMovieBuilder()
                        .withName("Memento")
                        .withMovieId("123")
                        .build()
        );

        assertFalse(
                new UserCanWatchMovie().canWatch(
                        john,
                        MovieBuilder
                                .aMovieBuilder()
                                .withName("Memento")
                                .withMovieId("123")
                                .build()
                ));

    }
}
