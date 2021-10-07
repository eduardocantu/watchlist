package com.cantu.watchlist.at;

import com.cantu.watchlist.WatchListSpringBootApplication;
import com.cantu.watchlist.at.dto.Movie;
import com.cantu.watchlist.at.dto.Provider;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {WatchListSpringBootApplication.class, H2JpaConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ProviderShould {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void beAddedWhenRequested() throws Exception {
        final String providerName = UUID.randomUUID().toString();

        final JSONObject requestBody = JSONConverter.toJSON(
                new Provider(providerName)
        );

        final HttpEntity<String> response = restTemplate
                .postForEntity(
                        HttpUtils.getURI(port, "providers"),
                        HttpUtils.getRequestFor(requestBody),
                        String.class
                );

        assertNotNull(response);
        assertTrue(response.hasBody());

        final JSONObject responseBody = new JSONObject(response.getBody());

        assertEquals(
                providerName,
                responseBody.get("name")
        );

    }
}
