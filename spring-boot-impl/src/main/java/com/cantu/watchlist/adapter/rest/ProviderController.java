package com.cantu.watchlist.adapter.rest;

import com.cantu.watchlist.adapter.rest.dto.AddMovieResponseBody;
import com.cantu.watchlist.adapter.rest.dto.AddProviderCommandMapper;
import com.cantu.watchlist.adapter.rest.dto.AddProviderRequestBody;
import com.cantu.watchlist.adapter.rest.dto.AddProviderResponseBody;
import com.cantu.watchlist.core.domain.Provider;
import com.cantu.watchlist.infrastructure.CommandBus;
import com.cantu.watchlist.infrastructure.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    ResponseEntity<AddProviderResponseBody> create(@RequestBody AddProviderRequestBody requestBody) {
        final CommandResponse response = commandBus.push(
                new AddProviderCommandMapper()
                        .apply(requestBody)
        );

        final Provider createdProvider = (Provider) response.getResponse();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create(createdProvider.getId().get()))
                .body(new AddProviderResponseBody(
                        createdProvider.getId().get()
                ));
    }
}
