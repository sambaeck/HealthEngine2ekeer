package be.kdg.se3.health.devices;

import vendorY.drv.GlcDrv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by OEM on 25/09/2015.
 */
public class GlucoseAdapter implements Device {
    private GlcDrv glucoseDriver;
    private Collection<String> idList;
    private final String GLUCOSE_ID = "glucoselevel";


    public GlucoseAdapter() {
        idList = new ArrayList<String>();
        this.glucoseDriver = new GlcDrv();
        glucoseDriver.init();
        idList.add(GLUCOSE_ID);
    }

    @Override
    public Collection<String> initialize() {
        return idList;
    }

    @Override
    public double read(String id) throws DeviceException {
        double glucoseLevel;
        try {
            if (id.equals(GLUCOSE_ID)) {
                glucoseLevel= glucoseDriver.get_glcXYZ_value();
                return glucoseLevel;
            }
            else {
                return 0;
            }

        } catch (Exception e) {
            throw new DeviceException(e.getMessage(), e.getCause());
        }
    }
}
