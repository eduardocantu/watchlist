package com.cantu.watchlist.adapter.rest;

import com.cantu.watchlist.adapter.rest.dto.CreateMovieCommandMapper;
import com.cantu.watchlist.adapter.rest.dto.CreateMovieRequestBody;
import com.cantu.watchlist.infrastructure.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String create(@RequestBody CreateMovieRequestBody requestBody) {
        commandBus.push(
                new CreateMovieCommandMapper()
                        .apply(requestBody)
        );

        return "";
    }
}
