package com.cantu.watchlist.core.application.addProvider;

import com.cantu.ddd.framework.command.CommandHandler;
import com.cantu.ddd.framework.command.CommandResponse;
import com.cantu.watchlist.core.domain.ProviderBuilder;
import com.cantu.watchlist.core.domain.ProviderRepository;

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
