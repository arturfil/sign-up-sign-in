package com.arturofilio.arturoconsulting.Model;

public class UserAccountSettings {

    private String description;
    private long friends;
    private long photos;
    private String name;
    private String fat;
    private String bmi;
    private String muscle_mass;
    private String daily_activity;
    private String height;
    private String weight;
    private String profile_photo;

    public UserAccountSettings(String description, long friends, long photos, String name, String fat,
                               String bmi, String muscle_mass, String daily_activity, String height,
                               String weight, String profile_photo) {
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

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getMuscle_mass() {
        return muscle_mass;
    }

    public void setMuscle_mass(String muscle_mass) {
        this.muscle_mass = muscle_mass;
    }

    public String getDaily_activity() {
        return daily_activity;
    }

    public void setDaily_activity(String daily_activity) {
        this.daily_activity = daily_activity;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

}
