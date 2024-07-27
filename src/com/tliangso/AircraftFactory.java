package com.tliangso;

import com.tliangso.Flyable.Baloon;
import com.tliangso.Flyable.Coordinates;
import com.tliangso.Flyable.Flyable;
import com.tliangso.Flyable.Helicopter;
import com.tliangso.Flyable.JetPlane;


public class AircraftFactory {
    private static AircraftFactory provider = null;

    private long id = 0;

    private AircraftFactory() {

    }

    class UnkownFlyableException extends Exception {
        public UnkownFlyableException() {
            super("Unkown Flyable Detected !");
        }
    }

    public static synchronized AircraftFactory getInstance() {
        if (provider == null) {
            provider = new AircraftFactory();
        }

        return provider;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws UnkownFlyableException {

        switch (p_type) {
            case Constants.FLYABLE_BALOON:
                return new Baloon(this.id++, p_name, p_coordinates);

            case Constants.FLYABLE_HELI:
                return new Helicopter(this.id++, p_name, p_coordinates);

            case Constants.FLYABLE_JET:
                return new JetPlane(this.id++, p_name, p_coordinates);

            default:
                throw new UnkownFlyableException();
        }
    }
}
