package com.cantu.watchlist.adapter.rest.dto;

import com.cantu.watchlist.core.application.addProvider.AddProviderCommand;

import java.util.function.Function;

public class AddProviderCommandMapper implements Function<AddProviderRequestBody, AddProviderCommand> {

    @Override
    public AddProviderCommand apply(AddProviderRequestBody addProviderRequestBody) {
        return new AddProviderCommand(addProviderRequestBody.getName());
    }
}
