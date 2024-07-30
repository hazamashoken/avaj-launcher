package com.tliangso;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_oordinates) {
        super(p_id, p_name, p_oordinates);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);

        Integer longitude = this.coordinates.getLongitude();
        Integer latitude = this.coordinates.getLatitude();
        Integer height = this.coordinates.getHeight();

        switch (weather) {

        case Constants.WEATHER_SUN:
            System.out.printf(Constants.MESSAGE_SUN, "Baloon", this.name, this.id);
            this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
            break;

        case Constants.WEATHER_RAIN:
            System.out.printf(Constants.MESSAGE_RAIN, "Baloon", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 5);
            break;

        case Constants.WEATHER_FOG:
            System.out.printf(Constants.MESSAGE_FOG, "Baloon", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 3);
            break;

        case Constants.WEATHER_SNOW:
            System.out.printf(Constants.MESSAGE_SNOW, "Baloon", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 15);
            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.printf("%d %d %d\n", this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight());

            System.out.printf(Constants.MESSAGE_LAND, "Baloon", this.name, this.id);
            this.weatherTower.unregister(this);
            System.out.printf(Constants.MESSAGE_UNREGISTER, "Baloon", this.name, this.id);
        }
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        System.out.printf(Constants.MESSAGE_REGISTER, "Baloon", this.name, this.id);
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }
}
