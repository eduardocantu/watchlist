package com.cantu.watchlist.core.at.application.addProvider;

import com.cantu.watchlist.core.application.addProvider.AddProviderCommand;
import com.cantu.watchlist.core.application.addProvider.AddProviderCommandHandler;
import com.cantu.watchlist.core.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProviderCommandHandlerShould {

    @Test
    public void addNewProviderWhenCommanded() {
        final ProviderRepository providerRepository = new ProviderRepositoryInMemory();

        final AddProviderCommandHandler commandHandler = new AddProviderCommandHandler(providerRepository);

        commandHandler.handle(
                new AddProviderCommand("Netflix")
        );

        assertEquals(
                ProviderBuilder
                        .aProviderBuilder()
                        .withName("Netflix")
                        .build(),
                providerRepository.findById(
                        ProviderNameBuilder
                                .aProviderNameBuilder()
                                .withName("Netflix")
                                .build()
                )
        );

    }
}
