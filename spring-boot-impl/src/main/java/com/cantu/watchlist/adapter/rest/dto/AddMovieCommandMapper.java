package com.cantu.watchlist.adapter.rest.dto;

import com.cantu.watchlist.core.application.addMovie.AddMovieCommand;

import java.util.function.Function;

public class AddMovieCommandMapper implements Function<AddMovieRequestBody, AddMovieCommand> {
    @Override
    public AddMovieCommand apply(AddMovieRequestBody addMovieRequestBody) {
        return new AddMovieCommand(
                addMovieRequestBody.getMovie(),
                addMovieRequestBody.getImdb()
        );
    }
}
