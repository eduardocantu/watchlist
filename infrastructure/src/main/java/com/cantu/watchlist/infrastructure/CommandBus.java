package com.cantu.watchlist.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public final class CommandBus {

    private final Map<Class<Command>, CommandHandler> commandsHandlers;

    public CommandBus() {
        this.commandsHandlers = new HashMap<>();
    }

    public void registerHandler(CommandHandler handler) {
        commandsHandlers.put(getCommandFromHandler(handler), handler);
    }

    public CommandResponse push(Command command) {
        if (!commandsHandlers.containsKey(command.getClass())) {
            throw new RuntimeException(
                    String.format("No handler for command [%s].",
                            command.getClass().getName()));
        }

        return commandsHandlers.get(command.getClass()).handle(command);
    }

    private Class getCommandFromHandler(CommandHandler handler) {
        ParameterizedType type = (ParameterizedType) handler.getClass().getGenericInterfaces()[0];
        return (Class) type.getActualTypeArguments()[0];

    }
}
