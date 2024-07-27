package com.tliangso;

import java.util.Random;

import com.tliangso.Flyable.Coordinates;

public class WeatherProvider {
    private static WeatherProvider provider = null;

    private WeatherProvider() {

    }

    public static synchronized WeatherProvider getInstance() {
        if (provider == null) {
            provider = new WeatherProvider();
        }

        return provider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {

        String[] weatherConditions = {Constants.WEATHER_FOG, Constants.WEATHER_RAIN, Constants.WEATHER_SNOW, Constants.WEATHER_SUN};

        Random random = new Random(p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude());
        
        String weather = weatherConditions[random.nextInt(weatherConditions.length)];
        
        return weather;
    }

}
