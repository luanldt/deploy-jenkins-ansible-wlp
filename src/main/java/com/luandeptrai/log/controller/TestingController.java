package com.luandeptrai.log.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {
    @GetMapping("/")
    public String index() {
        return "{\"status\": \"OK\"}";
    }
}
