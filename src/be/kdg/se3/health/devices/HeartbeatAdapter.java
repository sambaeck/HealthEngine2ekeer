package be.kdg.se3.health.devices;

import vendorX.drivers.NoSignalException;
import vendorX.drivers.TypeXYZWatchDriver;

import java.io.IOException;
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

    public HeartbeatAdapter(int heartbeat, int stressLevel) {
        this.heartbeat = heartbeat;
        this.stressLevel = stressLevel;
        heartbeatDriver= new TypeXYZWatchDriver();
    }

    @Override
    public Collection<String> initialize() {
        return null;
    }

    @Override
    public double read(String id){
        try {
            if (id.equals(HEARTBEAT_ID)) {
                heartbeat = Double.parseDouble(heartbeatDriver.getHeartbeat() + "");
                return heartbeat;
            }
            else if (id.equals(STRESSLEVEL_ID)) {
                stressLevel = Double.parseDouble(heartbeatDriver.getStressLevel() + "");
                return stressLevel;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSignalException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
