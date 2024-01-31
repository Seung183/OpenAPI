package com.s1.contact;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8000/contacts/1"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        Contact contact = objectMapper.readValue(responseBody, Contact.class);

        System.out.println("contact.getName() = " + contact.getName());
        System.out.println("contact.getAddress() = " + contact.getAddress());
        System.out.println("contact.getPhoneNumber() = " + contact.getPhoneNumber());

    }
}
