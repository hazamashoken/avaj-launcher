package com.tliangso;

public abstract class Flyable {

    protected WeatherTower weatherTower = null;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }
}
