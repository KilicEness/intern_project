package com.example.demo;

import com.example.demo.entity.GITProfile;
import com.example.demo.repository.GITProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Integration Test'lerin Yazılacağı
 */
@SpringBootTest
class SpringTests {

    @Autowired
    private GITProfileRepository gitProfileRepository;

    @Test
    void gitProfileRepositoryTest1() {
        System.out.println("gitProfileRepository Test Started");
        Optional<GITProfile> gitProfileOpt = gitProfileRepository.findById(846546541545454545L);
        assertFalse(gitProfileOpt.isPresent());
    }

    @Test
    void gitProfileRepositoryTest2() {

        //TODO repository'e method yaz. maximum id'yi bul. altta onu bir arttırıp newUserId alanına setle. select max(t.id) from GıtPorfıile
        //findTopOrderByIdDesc
        //gitProfileRepository.yeniMethod
        GITProfile gitProfileExist = gitProfileRepository.findFirstByOrderByIdDesc();
        Long newUserId = gitProfileExist.getId() + 1;

        GITProfile gitProfile = new GITProfile();
        gitProfile.setId(newUserId);
        gitProfile.setLogin("test_user");

        GITProfile savedData = gitProfileRepository.save(gitProfile);
        assertNotNull(savedData);
        assertNotNull(savedData.getId());
    }

    @Test
    void gitProfileRepositoryTest3() {
        System.out.println("gitProfileRepository Test Started");

        GITProfile gitProfileExist = gitProfileRepository.findFirstByOrderByIdDesc();
        Long newUserId = gitProfileExist.getId() + 1;

        Optional<GITProfile> gitProfileOpt = gitProfileRepository.findById(newUserId);
        assertFalse(gitProfileOpt.isPresent());
    }

}
