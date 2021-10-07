package com.cantu.watchlist.adapter.rest;

import com.cantu.watchlist.adapter.rest.dto.AddMovieCommandMapper;
import com.cantu.watchlist.adapter.rest.dto.AddMovieRequestBody;
import com.cantu.watchlist.adapter.rest.dto.AddMovieResponseBody;
import com.cantu.watchlist.core.domain.Movie;
import com.cantu.watchlist.infrastructure.CommandBus;
import com.cantu.watchlist.infrastructure.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    ResponseEntity<AddMovieResponseBody> create(@RequestBody AddMovieRequestBody requestBody) {
        final CommandResponse response = commandBus.push(
                new AddMovieCommandMapper()
                        .apply(requestBody)
        );

        final Movie createdMovie = (Movie) response.getResponse();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create(createdMovie.getId().get()))
                .body(new AddMovieResponseBody(
                        createdMovie.getId().get(),
                        createdMovie.getName()));
    }
}
