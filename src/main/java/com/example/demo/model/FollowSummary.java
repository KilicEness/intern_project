package com.example.demo.model;

public class FollowSummary {

    private Long followingUserId;
    private String followingUserName;
    private Long takipEdenSayi;
    public FollowSummary() {
    }

    public FollowSummary(Long followingUserId, String followingUserName, Long takipEdenSayi) {
        this.followingUserId = followingUserId;
        this.followingUserName = followingUserName;
        this.takipEdenSayi = takipEdenSayi;
    }

    public Long getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(Long followingUserId) {
        this.followingUserId = followingUserId;
    }

    public String getFollowingUserName() {
        return followingUserName;
    }

    public void setFollowingUserName(String followingUserName) {
        this.followingUserName = followingUserName;
    }

    public Long getTakipEdenSayi() {
        return takipEdenSayi;
    }

    public void setTakipEdenSayi(Long takipEdenSayi) {
        this.takipEdenSayi = takipEdenSayi;
    }
}
