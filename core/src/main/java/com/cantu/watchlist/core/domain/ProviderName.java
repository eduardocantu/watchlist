package com.cantu.watchlist.core.domain;

import java.util.Objects;

public class ProviderName implements EntityId<String> {

    private final String name;

    protected ProviderName(String name) {
        this.name = name;
    }

    @Override
    public String get() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProviderName)) return false;
        ProviderName that = (ProviderName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
