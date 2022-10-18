package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserFollowing")
public class UserFollowing {

    @EmbeddedId
    private UserFollowingPK id;

    private String login;

    private String following_user_name;

    public UserFollowingPK getId() {
        return id;
    }

    public void setId(UserFollowingPK id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFollowing_user_name() {
        return following_user_name;
    }

    public void setFollowing_user_name(String following_user_name) {
        this.following_user_name = following_user_name;
    }
}
