package com.example.demo.repository;

import com.example.demo.entity.GITProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GITProfileRepository extends JpaRepository<GITProfile, Long> {

    List<GITProfile> findAllByFollowingKontrolEdildi(Boolean followingKontrolEdildi);

    GITProfile findFirstByOrderByIdDesc();

}
