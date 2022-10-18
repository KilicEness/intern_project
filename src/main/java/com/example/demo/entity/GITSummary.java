package com.example.demo.entity;

import com.example.demo.model.FollowSummary;

import java.util.List;

public class GITSummary {

    private String enCokTakipEdilen;
    private List<FollowSummary> enCokTakipEdilenler;

    public GITSummary() {
    }

    public String getEnCokTakipEdilen() {
        return enCokTakipEdilen;
    }

    public void setEnCokTakipEdilen(String enCokTakipEdilen) {
        this.enCokTakipEdilen = enCokTakipEdilen;
    }

    public List<FollowSummary> getEnCokTakipEdilenler() {
        return enCokTakipEdilenler;
    }

    public void setEnCokTakipEdilenler(List<FollowSummary> enCokTakipEdilenler) {
        this.enCokTakipEdilenler = enCokTakipEdilenler;
    }
}
