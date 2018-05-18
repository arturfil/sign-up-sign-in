package com.arturofilio.arturoconsulting.Model;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class Exercise {

    private int image_id;
    private String name;

    public Exercise(int iamge_id, String name) {
        this.image_id = iamge_id;
        this.name = name;
    }

    public int getIamge_id() {
        return image_id;
    }

    public void setIamge_id(int iamge_id) {
        this.image_id = iamge_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
