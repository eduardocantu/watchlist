package com.cantu.watchlist.core.application.addProvider;

import com.cantu.watchlist.core.domain.ProviderBuilder;
import com.cantu.watchlist.core.domain.ProviderRepository;
import com.cantu.watchlist.infrastructure.CommandHandler;
import com.cantu.watchlist.infrastructure.CommandResponse;

public class AddProviderCommandHandler implements CommandHandler<AddProviderCommand> {

    private final ProviderRepository providerRepository;

    public AddProviderCommandHandler(final ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public CommandResponse handle(AddProviderCommand command) {
        return CommandResponse.withResponse(
                providerRepository.save(
                        ProviderBuilder
                                .aProviderBuilder()
                                .withName(command.getName())
                                .build()
                )
        );
    }
}
