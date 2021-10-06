package com.cantu.watchlist.core.domain;

import java.util.List;

public interface Repository<K extends Entity> {

    void save(K entity);

    K findById(EntityId id);

    List<K> findAll();
}
