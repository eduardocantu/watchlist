package com.cantu.watchlist.infrastructure;

public final class CommandResponse {

    private final Object response;

    private CommandResponse(final Object response) {
        this.response = response;
    }

    public static CommandResponse withResponse(final Object response) {
        return new CommandResponse(response);
    }

    public Object getResponse() {
        return response;
    }
}
