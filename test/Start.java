import be.kdg.se3.health.devices.DeviceException;
import be.kdg.se3.health.devices.GlucoseAdapter;
import be.kdg.se3.health.devices.HeartbeatAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by OEM on 25/09/2015.
 */
public class Start {
    public static void main(String[] args) throws DeviceException {

        GlucoseAdapter glucoseAdapter = new GlucoseAdapter();
        HeartbeatAdapter heartbeatAdapter = new HeartbeatAdapter();
        Collection<String> idCollection = heartbeatAdapter.initialize();
        List<String> idList = new ArrayList<String>(idCollection);

        idList.addAll(glucoseAdapter.initialize());

        for (String id : idList) {
            try {
                heartbeatAdapter.read(id);
                glucoseAdapter.read(id);
            } catch (Exception e) {
                throw new DeviceException(e.getMessage(), e.getCause());
            }
        }


      /*  for(int i =0;i<10;i++){
            Parameter parameter = new Parameter(glucoseAdapter, 40,170,10,glucoseAdapter.read());
        }
*/
    }
}
