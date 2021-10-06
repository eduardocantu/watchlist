package com.cantu.watchlist.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieJPA {

    @Id
    private final String id;

    private final String name;

    public MovieJPA() {
        this(null, null);
    }

    public MovieJPA(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
