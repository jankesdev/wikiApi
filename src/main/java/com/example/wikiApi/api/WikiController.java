package com.example.wikiApi.api;

import com.example.wikiApi.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class WikiController {

    public WikiController() {
    }

    @GetMapping("club")
    public ApiResponse getClub(@RequestParam("name") String clubName) {
        return null; //todo
    }
}