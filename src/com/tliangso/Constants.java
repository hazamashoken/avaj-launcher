package com.tliangso;

public class Constants {
    public static final String FLYABLE_BALOON = "BALOON";
    public static final String FLYABLE_JET = "JETPLANE";
    public static final String FLYABLE_HELI = "HELICOPTER";

    public static final String WEATHER_RAIN = "RAIN";
    public static final String WEATHER_SNOW = "SNOW";
    public static final String WEATHER_SUN = "SUN";
    public static final String WEATHER_FOG = "FOG";

    public static final String MESSAGE_PREFIX = "%s#%s(%d): ";
    public static final String MESSAGE_REGISTER = "Tower says: " + MESSAGE_PREFIX + "registered to weather tower.\n";
    public static final String MESSAGE_UNREGISTER = "Tower says: " + MESSAGE_PREFIX
            + "unregistered from weather tower.\n";
    public static final String MESSAGE_SUN = MESSAGE_PREFIX + "It's sunny !\n";
    public static final String MESSAGE_RAIN = MESSAGE_PREFIX + "It's raining !\n";
    public static final String MESSAGE_FOG = MESSAGE_PREFIX + "It's foggy !\n";
    public static final String MESSAGE_SNOW = MESSAGE_PREFIX + "It's snowing !\n";
    public static final String MESSAGE_LAND = MESSAGE_PREFIX + "Landing.\n";

}
