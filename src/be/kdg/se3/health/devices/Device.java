package be.kdg.se3.health.devices;

import java.util.Collection;

/**
 * Created by OEM on 25/09/2015.
 */
public interface Device {
    Collection<String> initialize();
    double read(String id) throws DeviceException;
}
