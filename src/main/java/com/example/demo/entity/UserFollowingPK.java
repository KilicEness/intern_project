package com.example.demo.entity;

import java.io.Serializable;

public class UserFollowingPK implements Serializable {

    private Long id;

    private Long following_user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowing_user_id() {
        return following_user_id;
    }

    public void setFollowing_user_id(Long following_user_id) {
        this.following_user_id = following_user_id;
    }
}
