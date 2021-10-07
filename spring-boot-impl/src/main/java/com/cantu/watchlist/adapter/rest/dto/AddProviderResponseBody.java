package com.cantu.watchlist.adapter.rest.dto;

public class AddProviderResponseBody {

    private final String name;

    public AddProviderResponseBody(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
