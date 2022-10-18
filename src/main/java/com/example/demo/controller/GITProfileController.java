package com.example.demo.controller;

import com.example.demo.entity.GITProfile;
import com.example.demo.service.GITProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "hvl-git-profile-api")
public class GITProfileController {
    @Autowired
    private GITProfileService gitProfileService;

    @GetMapping(path ="/git_profile/{id}", produces =  "application/json")
    public ResponseEntity<GITProfile> getProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(gitProfileService.getProfileById(id), HttpStatus.OK);
    }

    @GetMapping(path ="/getProfiles", produces =  "application/json")
    public ResponseEntity<List<GITProfile>> getALlProfiles() {
        return new ResponseEntity<>(gitProfileService.getAllProfiles(), HttpStatus.OK);
    }

    @PutMapping(path = "/updateById/{id}" , produces =  "application/json")
    public ResponseEntity<GITProfile> updateProfileById(@PathVariable Long id, @RequestBody GITProfile gitProfile) {
        //TODO
        gitProfileService.updateProfileById(id, gitProfile);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping(path ="/git_profile/{id}", produces =  "application/json")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        gitProfileService.deleteProfileById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
