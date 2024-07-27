package com.tliangso;

public class AircraftFactory {
    private static AircraftFactory provider = null;

    private long id = 0;

    private AircraftFactory() {

    }

    public static synchronized AircraftFactory getInstance() {
        if (provider == null) {
            provider = new AircraftFactory();
        }

        return provider;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {

        switch (p_type.toUpperCase()) {
        case Constants.FLYABLE_BALOON:
            return new Baloon(this.id++, p_name, p_coordinates);

        case Constants.FLYABLE_HELI:
            return new Helicopter(this.id++, p_name, p_coordinates);

        case Constants.FLYABLE_JET:
            return new JetPlane(this.id++, p_name, p_coordinates);

        default:
            return new Aircraft(this.id++, p_name, p_coordinates);
        }

    }
}
