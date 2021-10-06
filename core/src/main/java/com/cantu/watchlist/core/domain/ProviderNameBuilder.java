package com.cantu.watchlist.core.domain;

public class ProviderNameBuilder {
    private String name;

    private ProviderNameBuilder() {
        super();
    }

    public static ProviderNameBuilder aProviderNameBuilder() {
        return new ProviderNameBuilder();
    }

    public ProviderNameBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProviderName build() {
        return new ProviderName(name);
    }
}