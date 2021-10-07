package com.cantu.watchlist.infrastructure.config;

import com.cantu.watchlist.core.application.addMovie.AddMovieCommandHandler;
import com.cantu.watchlist.core.application.addProvider.AddProviderCommandHandler;
import com.cantu.watchlist.core.domain.MovieRepository;
import com.cantu.watchlist.core.domain.ProviderRepository;
import com.cantu.watchlist.infrastructure.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandBusConfig {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Bean
    public CommandBus commandBus() {
        CommandBus commandBus = new CommandBus();

        commandBus.registerHandler(
                new AddMovieCommandHandler(movieRepository)
        );
        commandBus.registerHandler(
                new AddProviderCommandHandler(providerRepository)
        );

        return commandBus;
    }
}
