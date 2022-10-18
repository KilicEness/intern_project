package com.example.demo.service;

import com.example.demo.entity.GITProfile;

import java.util.List;

public interface GITProfileService {

    GITProfile getProfileById(Long id);

    List<GITProfile> getAllProfiles();

    GITProfile updateProfileById(Long id, GITProfile gitProfile);

    void deleteProfileById(Long id);



}
