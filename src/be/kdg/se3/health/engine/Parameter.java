package be.kdg.se3.health.engine;

import be.kdg.se3.health.devices.Device;

/**
 * Created by OEM on 25/09/2015.
 */
public class Parameter {
    private final String id;
    private final double readValue;

    public Parameter(double readValue, String id) {
        this.id = id;
        this.readValue = readValue;
    }


}
