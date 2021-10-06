package com.cantu.watchlist.core.domain.config;

import com.cantu.watchlist.core.domain.MovieRepository;
import com.cantu.watchlist.core.domain.MovieRepositoryJPAImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAConfig {

    @Autowired
    private MovieRepositoryJPAImpl movieRepositoryJPAImpl;

    @Bean
    public MovieRepository movieRepository() {
        return movieRepositoryJPAImpl;
    }
}
