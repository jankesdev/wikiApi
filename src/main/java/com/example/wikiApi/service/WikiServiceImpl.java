package com.example.wikiApi.service;

import com.example.wikiApi.response.ApiResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WikiServiceImpl implements WikiService {

    RestTemplate restTemplate;

    public WikiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ApiResponse getClubByName(String name) {
        return null;
    }
}
