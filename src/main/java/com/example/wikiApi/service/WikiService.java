package com.example.wikiApi.service;

import com.example.wikiApi.response.ApiResponse;

public interface WikiService {
    ApiResponse getClubByName(String name);
}
