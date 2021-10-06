package com.cantu.watchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WatchListSpringBootApplication {

    public static void main(String[] args) {

        final SpringApplication watchListApp =
                new SpringApplication(WatchListSpringBootApplication.class);
        watchListApp.run(args);
    }
}
