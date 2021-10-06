package com.cantu.watchlist.core.domain;

public class UserCanWatchMovie {

    public boolean canWatch(User user, Movie movie) {
        final boolean doesUserWantsToWatchIt = user.getWatchList().contains(movie);

        final boolean isMovieAvailableInOneOfTheProviders = user.getProviders()
                .stream()
                .filter(
                        provider -> provider.getAvailableMovies()
                                .stream()
                                .filter(availableMovie -> availableMovie.equals(movie)).count() > 0
                ).count() > 0;

        return doesUserWantsToWatchIt && isMovieAvailableInOneOfTheProviders;
    }
}
