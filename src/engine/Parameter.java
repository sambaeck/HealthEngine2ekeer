package engine;

import devices.Device;

/**
 * Created by OEM on 25/09/2015.
 */
public class Parameter {
    private final Device device;
    private final int minimumValue;
    private final int maximumValue;
    private final int offset;

    public Parameter(Device device, int minimumValue, int maximumValue, int offset) {
        this.device = device;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.offset = offset;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public int getOffset() {
        return offset;
    }
}
