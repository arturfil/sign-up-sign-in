package com.arturofilio.arturoconsulting.Model;

public class UserAccountSettings {

    private String description;
    private long friends;
    private long photos;
    private String name;
    private long fat;
    private long bmi;
    private long muscle_mass;
    private long daily_activity;
    private long height;
    private long weight;
    private String profile_photo;

    public UserAccountSettings(String description, long friends, long photos, String name,
                               long fat, long bmi, long muscle_mass, long daily_activity,
                               long height, long weight, String profile_photo) {
        this.description = description;
        this.friends = friends;
        this.photos = photos;
        this.name = name;
        this.fat = fat;
        this.bmi = bmi;
        this.muscle_mass = muscle_mass;
        this.daily_activity = daily_activity;
        this.height = height;
        this.weight = weight;
        this.profile_photo = profile_photo;
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

    public long getFat() {
        return fat;
    }

    public void setFat(long fat) {
        this.fat = fat;
    }

    public long getBmi() {
        return bmi;
    }

    public void setBmi(long bmi) {
        this.bmi = bmi;
    }

    public long getMuscle_mass() {
        return muscle_mass;
    }

    public void setMuscle_mass(long muscle_mass) {
        this.muscle_mass = muscle_mass;
    }

    public long getDaily_activity() {
        return daily_activity;
    }

    public void setDaily_activity(long daily_activity) {
        this.daily_activity = daily_activity;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

}
