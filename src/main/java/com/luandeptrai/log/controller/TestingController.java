package com.luandeptrai.log.controller;

import com.luandeptrai.log.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestingController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/")
    public String index() {
        return "{\"status\": \"OK\"}";
    }

    @GetMapping("/timestamp")
    public String getCurrentTimeInTimestamp() {
        Date date = new Date();
        String timestamp = timeService.getTimestampFromDate(date);
        return "{\"status\": \"OK\", \"timestamp\": \"" + timestamp + "\"}";
    }
}
