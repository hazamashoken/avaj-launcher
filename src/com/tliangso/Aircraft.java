package com.tliangso;

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

        String weather = this.weatherTower.getWeather(this.coordinates);

        Integer longitude = this.coordinates.getLongitude();
        Integer latitude = this.coordinates.getLatitude();
        Integer height = this.coordinates.getHeight();

        switch (weather) {
        case Constants.WEATHER_FOG:
            System.out.printf(Constants.MESSAGE_SUN, "Aircraft", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 2);
            break;

        case Constants.WEATHER_RAIN:
            System.out.printf(Constants.MESSAGE_SUN, "Aircraft", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 2);
            break;

        case Constants.WEATHER_SNOW:
            System.out.printf(Constants.MESSAGE_SUN, "Aircraft", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 2);
            break;

        case Constants.WEATHER_SUN:
            System.out.printf(Constants.MESSAGE_SUN, "Aircraft", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 2);
            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.printf(Constants.MESSAGE_LAND, "Aircraft", this.name, this.id);
            this.weatherTower.unregister(this);
            System.out.printf(Constants.MESSAGE_UNREGISTER, "Aircraft", this.name, this.id);
        }
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        System.out.printf(Constants.MESSAGE_REGISTER, "Aircraft", this.name, this.id);
        p_tower.register(this);
    }

}
