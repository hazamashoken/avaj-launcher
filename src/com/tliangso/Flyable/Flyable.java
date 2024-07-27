package com.tliangso.Flyable;

import com.tliangso.Tower.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower = null;

    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }
}
