package com.arturofilio.arturoconsulting.Model;

public class UserAccountSettings {

    private String description;
    private long friends;
    private long photos;
    private String name;


    public UserAccountSettings(String description, long friends, long photos, String name) {
        this.description = description;
        this.friends = friends;
        this.photos = photos;
        this.name = name;
    }

    public UserAccountSettings() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFriends() {
        return friends;
    }

    public void setFriends(long friends) {
        this.friends = friends;
    }

    public long getPhotos() {
        return photos;
    }

    public void setPhotos(long photos) {
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
