package be.kdg.se3.health.devices;

import vendorX.drivers.NoSignalException;
import vendorX.drivers.TypeXYZWatchDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by OEM on 25/09/2015.
 */
public class HeartbeatAdapter implements Device {
    private double heartbeat;
    private double stressLevel;
    private TypeXYZWatchDriver heartbeatDriver;
    private final String HEARTBEAT_ID = "heartbeat";
    private final String STRESSLEVEL_ID = "stresslevel";
    private Collection<String> idList;

    public HeartbeatAdapter() {
        heartbeatDriver= new TypeXYZWatchDriver();
        idList = new ArrayList<String>();
        idList.add(HEARTBEAT_ID);
        idList.add(STRESSLEVEL_ID);
    }

    @Override
    public Collection<String> initialize() {
        return idList;
    }

    @Override
    public double read(String id) throws DeviceException {
        try {
            if (id.equals(HEARTBEAT_ID)) {
                return Double.parseDouble(heartbeatDriver.getHeartbeat() + "");

            }
            else if (id.equals(STRESSLEVEL_ID)) {
                return Double.parseDouble(heartbeatDriver.getStressLevel() + "");

            }

        } catch (Exception e) {
            throw new DeviceException(e.getMessage(), e.getCause());
        }

        return 0;
    }
}
