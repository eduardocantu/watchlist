package com.cantu.watchlist.infrastructure.at;

import com.cantu.watchlist.infrastructure.Command;
import com.cantu.watchlist.infrastructure.CommandBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandBusShould {

    @Test
    public void callTheProperHandlerGivenTheCommandToHandle() {
        final MockCommandHandler commandHanlder = new MockCommandHandler();

        final CommandBus commandBus = new CommandBus();
        commandBus.registerHandler(commandHanlder);

        final Command command = new MockCommand();

        assertNotNull(commandBus.push(command).getResponse());
        assertEquals(command, commandHanlder.getHandledCommand());
    }


}
