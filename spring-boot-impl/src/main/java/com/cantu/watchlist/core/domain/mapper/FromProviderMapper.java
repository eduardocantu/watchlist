package com.cantu.watchlist.core.domain.mapper;

import com.cantu.watchlist.core.domain.Provider;
import com.cantu.watchlist.core.domain.ProviderJPA;

import java.util.function.Function;

public class FromProviderMapper implements Function<Provider, ProviderJPA> {

    @Override
    public ProviderJPA apply(Provider provider) {
        return new ProviderJPA(provider.getId().get());
    }
}
