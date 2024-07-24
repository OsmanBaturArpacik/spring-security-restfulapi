package com.roofstacks.restapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiFetchService {
    private final RestTemplate restTemplate;
    @Autowired
    public ApiFetchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        return response.getBody();
    }

    public String getPostsById(String id) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Validasyon
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }

        try {
            int numericId = Integer.parseInt(id);
            if (numericId < 1 || numericId > 100) {
                return "Invalid id argument";
            }
        } catch (NumberFormatException e) {
            return "Invalid id format";
        }

        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .path("/{id}").buildAndExpand(id).toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
//        ResponseEntity<Object> response = restTemplate.getForEntity(uriString, Object.class);

        return response.getBody();
    }
}