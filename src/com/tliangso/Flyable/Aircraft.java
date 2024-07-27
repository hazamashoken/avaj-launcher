package com.tliangso.Flyable;

import com.tliangso.Constants;
import com.tliangso.WeatherProvider;
import com.tliangso.Tower.Tower.UnregisterFlyable;
import com.tliangso.Tower.WeatherTower;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {
        WeatherProvider provider = WeatherProvider.getInstance();

        String weather = provider.getCurrentWeather(this.coordinates);

        switch (weather) {
            case Constants.WEATHER_FOG:
                break;

            case Constants.WEATHER_RAIN:
                break;

            case Constants.WEATHER_SNOW:
                break;

            case Constants.WEATHER_SUN:
                break;
        }

        if (this.coordinates.getHeight() <= 0 ){
            try {
                this.weatherTower.unregister(this);
            } catch (UnregisterFlyable e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    
}
