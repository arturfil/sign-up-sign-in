package com.arturofilio.arturoconsulting.Model;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class Exercise {

    private String image_id;
    private String name;

    public Exercise(String image_id, String name) {
        this.image_id = image_id;
        this.name = name;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
