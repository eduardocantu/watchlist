package com.cantu.watchlist.core.application.addProvider;

import com.cantu.watchlist.infrastructure.Command;

public class AddProviderCommand implements Command {

    private final String name;

    public AddProviderCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
