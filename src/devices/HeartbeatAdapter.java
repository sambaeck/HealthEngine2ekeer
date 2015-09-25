package devices;

/**
 * Created by OEM on 25/09/2015.
 */
public class HeartbeatAdapter implements Device {
    private int heartbeat;
    private int stressLevel;

    public HeartbeatAdapter(int heartbeat, int stressLevel) {
        this.heartbeat = heartbeat;
        this.stressLevel = stressLevel;
    }


    @Override
    public void read() {

    }
}
