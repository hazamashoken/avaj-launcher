package com.tliangso.Flyable;

import com.tliangso.Constants;
import com.tliangso.WeatherProvider;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_oordinates) {
        super(p_id, p_name, p_oordinates);
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
