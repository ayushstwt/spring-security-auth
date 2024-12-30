package com.ayshriv.securityauthconsumerapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class WelcomeService {

    @Autowired
    RestTemplate restTemplate;

    public String getAuthenticatedResponse() {
        HttpHeaders headers = new HttpHeaders();
        String auth = "ayshriv" + ":" + "ayshriv@123";
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = "http://localhost:8080/greeting";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String getNormalResponse() {
        String url = "http://localhost:8080/welcome";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null, String.class);
        return response.getBody();
    }


}
