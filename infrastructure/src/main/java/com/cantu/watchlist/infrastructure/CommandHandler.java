package com.cantu.watchlist.infrastructure;

public interface CommandHandler<K extends Command> {

    void handle(K command);
}
