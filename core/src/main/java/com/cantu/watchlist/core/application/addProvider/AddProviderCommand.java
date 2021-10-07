package com.cantu.watchlist.core.application.addProvider;

import com.cantu.ddd.framework.command.Command;

public class AddProviderCommand implements Command {

    private final String name;

    public AddProviderCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
