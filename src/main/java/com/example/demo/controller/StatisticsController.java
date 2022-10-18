package com.example.demo.controller;

import com.example.demo.entity.GITSummary;
import com.example.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hvl-git-statistics-api" )
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(path = "/getSummary", produces = "application/json")
    public ResponseEntity<GITSummary> getSummary() {
        return new ResponseEntity<>(statisticsService.getSummary(), HttpStatus.OK);
    }

}
