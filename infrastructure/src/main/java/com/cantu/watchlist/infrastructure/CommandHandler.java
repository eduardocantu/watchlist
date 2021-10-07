package com.cantu.watchlist.infrastructure;

public interface CommandHandler<K extends Command> {

    CommandResponse handle(K command);
}
