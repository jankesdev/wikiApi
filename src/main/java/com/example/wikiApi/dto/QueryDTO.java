package com.example.wikiApi.dto;

import lombok.Data;

import java.util.List;

@Data
public class QueryDTO {
    private List<SearchDTO> search;
}
