package com.s1.contact.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s1.contact.domain.ApiKeyInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GetResourceService {

    public ApiKeyInfo getResouce() throws URISyntaxException, IOException, InterruptedException {

        String apiKey = "771d38da9b7864bed31c6105a0b515f9";
        String apiUrl = "http://server.com:8080/contacts";
        String origin = "http://test.com:8000";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl+"?key="+apiKey))
                .header("Origin",origin)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper objectMapper = new ObjectMapper();
        ApiKeyInfo apiKeyInfo = objectMapper.readValue(response.body(), ApiKeyInfo.class);

        return apiKeyInfo;
    }
}
