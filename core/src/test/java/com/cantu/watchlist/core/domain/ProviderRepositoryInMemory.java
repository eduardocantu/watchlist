package com.cantu.watchlist.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProviderRepositoryInMemory implements ProviderRepository {

    private final Map<EntityId, Provider> providers;

    public ProviderRepositoryInMemory() {
        providers = new HashMap<>();
    }

    @Override
    public void save(Provider entity) {
        providers.put(entity.getId(), entity);
    }

    @Override
    public Provider findById(EntityId id) {
        return providers.get(id);
    }

    @Override
    public List<Provider> findAll() {
        return providers.values().stream().collect(Collectors.toList());
    }
}
