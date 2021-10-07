package com.cantu.watchlist.at.lib;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.net.URI;
import java.net.URISyntaxException;

public final class HttpUtils {

    private HttpUtils() {
        super();
    }

    public static URI getURI(final int port, final String endpoint) throws URISyntaxException {
        return EndpointResolver
                .aEndpointResolverFor(port)
                .getEndpointURIFor(endpoint);
    }

    public static HttpEntity<String> getRequestFor(JSONObject requestBody) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity(
                requestBody.toString(),
                headers);
    }
}
