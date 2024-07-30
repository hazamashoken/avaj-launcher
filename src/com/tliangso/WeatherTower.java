package com.tliangso;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        WeatherProvider provider = WeatherProvider.getInstance();

        return provider.getCurrentWeather(p_coordinates);
    };

    public void changeWeather() {
        this.conditionChanged();
    };
}
