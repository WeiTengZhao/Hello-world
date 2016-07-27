package com.test.listviewtest;

/**
 * Created by Shao on 2016-07-24.
 */
public class Location {
    private String name;
    private int imageId;

    public  Location(String name,int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }
    public String getName(){
        return name;
    }
}
