package com.example.demo.repository;

import com.example.demo.entity.UserFollowing;
import com.example.demo.model.FollowSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFollowingRepository extends JpaRepository<UserFollowing, Long> {

    List<UserFollowing> findAllByOrderByIdDesc();

    @Query(value = "select new com.example.demo.model.FollowSummary(uf.id.following_user_id as followingUserId , uf.following_user_name as followingUserName, count(uf) as takipEdenSayi) " +
            "from UserFollowing uf " +
            "group by uf.id.following_user_id, uf.following_user_name having count(uf) > 10")
    List<FollowSummary> mostfollowing();

}
