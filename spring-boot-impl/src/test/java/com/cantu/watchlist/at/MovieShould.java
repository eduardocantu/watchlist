package com.cantu.watchlist.at;

import com.cantu.watchlist.WatchListSpringBootApplication;
import com.cantu.watchlist.at.dto.Movie;
import com.cantu.watchlist.at.lib.HttpUtils;
import com.cantu.watchlist.at.lib.JSONConverter;
import com.cantu.watchlist.config.H2JpaConfig;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {WatchListSpringBootApplication.class, H2JpaConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class MovieShould {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void beAddedWhenRequested() throws Exception {
        final String movieName = UUID.randomUUID().toString();
        final String movieImdb = UUID.randomUUID().toString();

        final JSONObject requestBody = JSONConverter.toJSON(
                new Movie(movieName, movieImdb)
        );

        final HttpEntity<String> response = restTemplate
                .postForEntity(
                        HttpUtils.getURI(port, "movies"),
                        HttpUtils.getRequestFor(requestBody),
                        String.class
                );

        assertNotNull(response);
        assertTrue(response.hasBody());

        final JSONObject responseBody = new JSONObject(response.getBody());

        assertEquals(
                movieName,
                responseBody.get("movie")
        );

        assertEquals(
                movieImdb,
                responseBody.get("imdb")
        );
    }
}
