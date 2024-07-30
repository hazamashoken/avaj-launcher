package com.tliangso;

public class Coordinates {
    private Integer longitude;
    private Integer latitude;
    private Integer height;

    Coordinates(Integer longitude, Integer latitude, Integer height) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100) {
            height = 100;
        }
        this.height = height;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public Integer getHeight() {
        return this.height;
    }

}
