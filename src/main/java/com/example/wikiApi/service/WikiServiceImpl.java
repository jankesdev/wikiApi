package com.example.wikiApi.service;

import com.example.wikiApi.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Service
public class WikiServiceImpl implements WikiService {

    @Value("${wikiApi.urlApi}")
    private String URL_API;

    RestTemplate restTemplate;

    public WikiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ApiResponse getClubByName(String name) {

        URI uri = URI.create(URL_API + "?action=query&list=search&format=json&srsearch=%22" + name + "%22&srlimit=10");

        try {

        } catch (RestClientException e) {
            log.error("Server problem. Check api key");
        }

        return null;
    }
}
