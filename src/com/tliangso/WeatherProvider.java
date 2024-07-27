package com.tliangso;

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

        String[] weatherConditions = { Constants.WEATHER_RAIN, Constants.WEATHER_FOG, Constants.WEATHER_SUN,
                Constants.WEATHER_SNOW };

        Integer num = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();

        return weatherConditions[num % 4];
    }

}
