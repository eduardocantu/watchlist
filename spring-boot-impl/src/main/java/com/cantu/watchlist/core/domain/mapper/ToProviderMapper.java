package com.cantu.watchlist.core.domain.mapper;

import com.cantu.watchlist.core.domain.Provider;
import com.cantu.watchlist.core.domain.ProviderBuilder;
import com.cantu.watchlist.core.domain.ProviderJPA;

import java.util.function.Function;

public class ToProviderMapper implements Function<ProviderJPA, Provider> {

    @Override
    public Provider apply(ProviderJPA providerJPA) {
        return ProviderBuilder
                .aProviderBuilder()
                .withName(providerJPA.getName())
                .build();
    }
}
