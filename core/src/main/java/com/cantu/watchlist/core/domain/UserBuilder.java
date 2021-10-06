package com.cantu.watchlist.core.domain;

import java.util.List;

public class UserBuilder {
    private String name;

    private UserBuilder() {
    }

    public static UserBuilder aUserBuilder() {
        return new UserBuilder();
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public User build() {
        return new User(name);
    }
}