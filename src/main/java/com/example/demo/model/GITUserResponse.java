package com.example.demo.model;

import com.example.demo.entity.GITProfile;

import java.util.List;

public class GITUserResponse {

    private Integer total_count;

    private Boolean incomplete_results;

    private List<GITProfile> items;

    public GITUserResponse() {
    }

    public GITUserResponse(Integer total_count, Boolean incomplete_results, List<GITProfile> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<GITProfile> getItems() {
        return items;
    }

    public void setItems(List<GITProfile> items) {
        this.items = items;
    }
}
