package androiddevelopment.assignment_4;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;

/**
 * Created by J on 23/10/2015.
 */
public class ZoneManager {

    public ArrayList<Zone> getZoneList() {
        return zoneList;
    }

    ArrayList<Zone> zoneList;
    GoogleMap mMap;

    ZoneManager(GoogleMap mMap) {
        this.zoneList = new ArrayList<>();
        this.mMap = mMap;
        initZoneList();
    }

    private void initZoneList() {

        this.zoneList.add(new Zone(mMap, 55.6087972, 12.9933342, "School"));
        this.zoneList.add(new Zone(mMap, 55.606971, 12.996221, "Bridge1"));
        this.zoneList.add(new Zone(mMap, 55.6045782, 12.9973829, "LillaTorg(ish)"));
        this.zoneList.add(new Zone(mMap, 55.5998191, 12.9996838, "Bridge2"));
        this.zoneList.add(new Zone(mMap, 55.5936636, 13.002097, "Church"));
        this.zoneList.add(new Zone(mMap, 55.592958, 13.003435, "Home"));
    }


    public InZone locationIsWithinZone(Location location) {

        float[] resultDistance = new float[2]; //holds the outputted result of the distanceBetween method
        double zoneLat;
        double zoneLong;
        double zoneRadius;
        InZone result = null;

            for (int i = 0; i < zoneList.size(); i++) {
                zoneLat = zoneList.get(i).getCircle().getCenter().latitude;
                zoneLong = zoneList.get(i).getCircle().getCenter().longitude;
                zoneRadius = zoneList.get(i).getCircle().getRadius();

                //initializes result[] with distance between location position and zone centre
                Location.distanceBetween(location.getLatitude(), location.getLongitude(),
                        zoneLat, zoneLong, resultDistance);

                //first position in array is the distance between two points
                if (resultDistance[0] <= zoneRadius) {
                    result = new InZone(zoneList.get(i), true);
                    return result;
                }
            }
        return result;
    }
}