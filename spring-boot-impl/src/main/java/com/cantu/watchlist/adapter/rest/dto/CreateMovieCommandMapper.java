package com.cantu.watchlist.adapter.rest.dto;

import com.cantu.watchlist.core.application.CreateMovieCommand;

import java.util.function.Function;

public class CreateMovieCommandMapper implements Function<CreateMovieRequestBody, CreateMovieCommand> {
    @Override
    public CreateMovieCommand apply(CreateMovieRequestBody createMovieRequestBody) {
        return new CreateMovieCommand(
                createMovieRequestBody.getMovie(),
                createMovieRequestBody.getImdb()
        );
    }
}
