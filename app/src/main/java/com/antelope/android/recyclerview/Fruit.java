package com.antelope.android.recyclerview;

public class Fruit {

    private String name;

    private int ImageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        ImageId = imageId;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getName() {
        return name;
    }

}
