package be.kdg.se3.health.devices;

import vendorY.drv.GlcDrv;

import java.util.Collection;

/**
 * Created by OEM on 25/09/2015.
 */
public class GlucoseAdapter implements Device {
    private double glucoseLevel;
    private GlcDrv glucoseDriver;


    public GlucoseAdapter() {
        this.glucoseDriver = new GlcDrv();
        glucoseDriver.init();

    }

    @Override
    public double read(String id) {
        this.glucoseLevel = glucoseDriver.get_glcXYZ_value();
        return this.glucoseLevel;
    }

    public void setGlucoseLevel(double glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public double getGlucoseLevel() {
        return glucoseLevel;
    }

    @Override
    public Collection<String> initialize() {
        return null;
    }
}
