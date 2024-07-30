package com.tliangso;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
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
            System.out.printf(Constants.MESSAGE_SUN, "JetPlane", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
            break;

        case Constants.WEATHER_RAIN:
            System.out.printf(Constants.MESSAGE_RAIN, "JetPlane", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude + 5, height);
            break;

        case Constants.WEATHER_FOG:
            System.out.printf(Constants.MESSAGE_FOG, "JetPlane", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude + 1, height);
            break;

        case Constants.WEATHER_SNOW:
            System.out.printf(Constants.MESSAGE_SNOW, "JetPlane", this.name, this.id);
            this.coordinates = new Coordinates(longitude, latitude, height - 7);
            break;

        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.printf("%d %d %d\n", this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight());

            System.out.printf(Constants.MESSAGE_LAND, "JetPlane", this.name, this.id);
            this.weatherTower.unregister(this);
            System.out.printf(Constants.MESSAGE_UNREGISTER, "JetPlane", this.name, this.id);
        }
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        System.out.printf(Constants.MESSAGE_REGISTER, "JetPlane", this.name, this.id);
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }
}
