package com.tliangso.Flyable;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public int updateLongitude(int magnitute) {
        return this.longitude += magnitute;
    }

    public int updateLatitude(int magnitute) {
        return this.latitude += magnitute;
    }

    public int updateHeight(int magnitute) {
        this.height += magnitute;
        if (this.height > 100) {
            this.height = 100;
        } 
        return this.height;
    }

}
