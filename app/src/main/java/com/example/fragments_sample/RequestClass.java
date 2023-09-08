package com.example.fragments_sample;

public class RequestClass {
    private String userEmail;
    private String badgeId;
    private String status;

    public RequestClass(){

    }

    public RequestClass(String userEmail, String badgeId, String status) {
        this.userEmail = userEmail;
        this.badgeId = badgeId;
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public String getStatus() {
        return status;
    }
}
