package com.example.wikiApi.service;

import com.example.wikiApi.dto.ResultDTO;
import com.example.wikiApi.dto.SearchDTO;
import com.example.wikiApi.exception.InternalServerException;
import com.example.wikiApi.exception.NotFoundException;
import com.example.wikiApi.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
public class WikiServiceImpl implements WikiService {

    @Value("${wikiApi.urlApi}")
    private String URL_API;

    @Value("${wikiApi.urlResponse}")
    private String URL_RESPONSE;

    RestTemplate restTemplate;

    public WikiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ApiResponse getClubByName(String name) {

        name = name.replaceAll("\\s+","_");

        URI uri = URI.create(URL_API + "?action=query&list=search&format=json&srsearch=%22" + name + "%22&srlimit=10");

        List<SearchDTO> searchDTOS;

        try {
            ResponseEntity<ResultDTO> responseEntity = restTemplate.getForEntity(uri, ResultDTO.class);
            searchDTOS = responseEntity.getBody().getQuery().getSearch();
        } catch (RestClientException e) {
            log.error("Server problem with api, check api");
            throw new InternalServerException("Server problem. Check api");
        }

        if(searchDTOS.isEmpty()) {
            throw new NotFoundException("Not found club for '" + name + "'");
        }

        SearchDTO searchDTO = searchDTOS.get(0);

        String urlResponse = URL_RESPONSE + searchDTO.getTitle().replaceAll("\\s+", "_");

        return new ApiResponse(searchDTO.getTitle(), urlResponse, searchDTO.getSnippet());
    }
}
