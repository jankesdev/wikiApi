package com.example.wikiApi.api;

import com.example.wikiApi.response.ApiResponse;
import com.example.wikiApi.service.WikiServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class WikiController {

    WikiServiceImpl wikiService;

    public WikiController(WikiServiceImpl wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping("club")
    public ApiResponse getClub(@RequestParam("name") String clubName) {
        return wikiService.getClubByName(clubName);
    }
}