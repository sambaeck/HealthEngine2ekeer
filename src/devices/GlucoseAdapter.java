package devices;

/**
 * Created by OEM on 25/09/2015.
 */
public class GlucoseAdapter implements Devices {
    private int glucoseLevel;

    public GlucoseAdapter(int glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    @Override
    public void read() {

    }
}
