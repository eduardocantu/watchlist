package com.cantu.watchlist.core.domain;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepositoryJPA extends CrudRepository<MovieJPA, String> {
}
