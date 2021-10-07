package com.cantu.watchlist.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROVIDER")
public class ProviderJPA {

    @Id
    private final String name;

    public ProviderJPA() {
        this(null);
    }

    public ProviderJPA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
