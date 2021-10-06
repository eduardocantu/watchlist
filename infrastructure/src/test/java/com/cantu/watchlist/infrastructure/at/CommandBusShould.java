package com.cantu.watchlist.infrastructure.at;

import com.cantu.watchlist.infrastructure.Command;
import com.cantu.watchlist.infrastructure.CommandBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandBusShould {

    @Test
    public void callTheProperHandlerGivenTheCommandToHandle() {
        final MockCommandHandler commandHanlder = new MockCommandHandler();

        final CommandBus commandBus = new CommandBus();
        commandBus.registerHandler(commandHanlder);

        final Command command = new MockCommand();
        commandBus.push(command);

        assertEquals(command, commandHanlder.getHandledCommand());
    }


}
