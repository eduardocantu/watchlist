package com.cantu.watchlist.infrastructure.at;

import com.cantu.watchlist.infrastructure.Command;
import com.cantu.watchlist.infrastructure.CommandHandler;

public class MockCommandHandler implements CommandHandler<MockCommand> {

    private Command command;

    @Override
    public void handle(MockCommand mockCommand) {
        this.command = mockCommand;
    }

    public Command getHandledCommand() {
        return command;
    }
}

