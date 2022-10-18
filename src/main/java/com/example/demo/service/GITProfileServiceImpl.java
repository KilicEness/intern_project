package com.example.demo.service;

import com.example.demo.entity.GITProfile;
import com.example.demo.repository.GITProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GITProfileServiceImpl implements GITProfileService {

    private final GITProfileRepository gitProfileRepository;

    @Autowired
    public GITProfileServiceImpl(GITProfileRepository gitProfileRepository) {
        this.gitProfileRepository = gitProfileRepository;
    }

    @Override
    public GITProfile getProfileById(Long id) {
        Optional<GITProfile> optGıtProfile = gitProfileRepository.findById(id);
        return optGıtProfile.isPresent() ? optGıtProfile.get() : null;
    }

    @Override
    public List<GITProfile> getAllProfiles() {
        return gitProfileRepository.findAll();
    }


    @Override
    public GITProfile updateProfileById(Long id, GITProfile gitProfile) {  //kullanıcıları update etme

        GITProfile updateProfile = gitProfileRepository.findById(id).get();
        updateProfile.setLogin(gitProfile.getLogin());


        return gitProfileRepository.save(updateProfile);


    }

    @Override
    public void deleteProfileById(Long id) {
        gitProfileRepository.deleteById(id);
    }


}

