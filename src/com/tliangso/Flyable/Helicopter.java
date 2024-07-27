package com.tliangso.Flyable;

import com.tliangso.Constants;
import com.tliangso.WeatherProvider;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
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
    }
}
