package com.cantu.watchlist.core.domain;

public class ProviderBuilder {
    private String name;

    private ProviderBuilder() {
    }

    public static ProviderBuilder aProviderBuilder() {
        return new ProviderBuilder();
    }

    public ProviderBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Provider build() {
        return new Provider(
                ProviderNameBuilder
                        .aProviderNameBuilder()
                        .withName(name)
                        .build()
        );
    }
}