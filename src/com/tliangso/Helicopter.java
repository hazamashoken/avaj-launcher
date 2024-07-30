package com.tliangso;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);

        Integer longitude = this.coordinates.getLongitude();
        Integer latitude = this.coordinates.getLatitude();
        Integer height = this.coordinates.getHeight();

        switch (weather) {
        case Constants.WEATHER_SUN:
            System.out.printf(Constants.MESSAGE_SUN, "Helicopter", this.name, this.id);
            this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
            break;

        case Constants.MESSAGE_RAIN:
            System.out.printf(Constants.MESSAGE_RAIN, "Helicopter", this.name, this.id);
            this.coordinates = new Coordinates(longitude + 5, latitude, height);
            break;

        case Constants.WEATHER_FOG:
            System.out.printf(Constants.MESSAGE_FOG, "Helicopter", this.name, this.id);
            this.coordinates = new Coordinates(longitude + 1, latitude, height);
            break;

        case Constants.WEATHER_SNOW:
            System.out.printf(Constants.MESSAGE_SNOW, "Helicopter", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 12);
            break;

        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.printf("%d %d %d\n", this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight());

            System.out.printf(Constants.MESSAGE_LAND, "Helicopter", this.name, this.id);
            this.weatherTower.unregister(this);
            System.out.printf(Constants.MESSAGE_UNREGISTER, "Helicopter", this.name, this.id);
        }
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        System.out.printf(Constants.MESSAGE_REGISTER, "Helicopter", this.name, this.id);
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }
}
