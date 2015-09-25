package devices;

import vendorY.drv.GlcDrv;

/**
 * Created by OEM on 25/09/2015.
 */
public class GlucoseAdapter implements Device {
    private double glucoseLevel;
    private GlcDrv glucoseDriver;


    public GlucoseAdapter() {
        this.glucoseDriver = new GlcDrv();
    }

    @Override
    public void read() {
        glucoseDriver.init();
        this.glucoseLevel = glucoseDriver.get_glcXYZ_value();
    }

    public void setGlucoseLevel(double glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }
}
