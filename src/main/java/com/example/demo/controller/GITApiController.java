package com.example.demo.controller;

import com.example.demo.service.GITApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hvl-git-api")
public class GITApiController {
    @Autowired
    private GITApiService gitApiService;

    public GITApiController(GITApiService gitApiService) {
        this.gitApiService = gitApiService;
    }

    @GetMapping(path = "/gitApiVeriCek", produces = "application/json")
    public ResponseEntity<String> gitApiVeriCek() {
        gitApiService.gitApiVeriCek();
        return new ResponseEntity<>("TAMAMLANDI", HttpStatus.OK);
    }

    @GetMapping(path = "/gitUserFollowingCek", produces = "application/json")
    public ResponseEntity<String> gitUserFollowingCek() {
        gitApiService.gitUserFollowingCek();
        return new ResponseEntity<>("TAMAMLANDI", HttpStatus.OK);
    }

}
