package com.cantu.watchlist.adapter.rest;

import com.cantu.watchlist.adapter.rest.dto.AddProviderCommandMapper;
import com.cantu.watchlist.adapter.rest.dto.AddProviderRequestBody;
import com.cantu.watchlist.adapter.rest.dto.AddProviderResponseBody;
import com.cantu.watchlist.core.domain.Provider;
import com.cantu.watchlist.infrastructure.CommandBus;
import com.cantu.watchlist.infrastructure.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    AddProviderResponseBody create(@RequestBody AddProviderRequestBody requestBody) {
        final CommandResponse response = commandBus.push(
                new AddProviderCommandMapper()
                        .apply(requestBody)
        );

        final Provider createdProvider = (Provider) response.getResponse();

        return new AddProviderResponseBody(
                createdProvider.getId().get()
        );
    }
}
