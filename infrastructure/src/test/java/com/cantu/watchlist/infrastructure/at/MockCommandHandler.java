package com.cantu.watchlist.infrastructure.at;

import com.cantu.watchlist.infrastructure.Command;
import com.cantu.watchlist.infrastructure.CommandHandler;
import com.cantu.watchlist.infrastructure.CommandResponse;

public class MockCommandHandler implements CommandHandler<MockCommand> {

    private Command command;

    @Override
    public CommandResponse handle(MockCommand mockCommand) {
        this.command = mockCommand;
        return CommandResponse.withResponse("");
    }

    public Command getHandledCommand() {
        return command;
    }
}

