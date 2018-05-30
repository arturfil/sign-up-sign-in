package com.arturofilio.arturoconsulting.Utils;

public class StringManipulation {

    public static String expandUsername(String name) {
        return name.replace(",", " ");
    }

    public static String condenseUsername(String name){
        return name.replace(" ", ".");
    }

}
