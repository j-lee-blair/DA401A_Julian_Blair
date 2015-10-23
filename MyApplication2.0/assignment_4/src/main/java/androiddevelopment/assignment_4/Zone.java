package androiddevelopment.assignment_4;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by J on 23/10/2015.
 */
public class Zone {

    private double latitude;
    private double longitude;
    private Circle radius;
    private GoogleMap mMap;
    private String name;

    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public Circle getCircle() {return radius;}
    public String getName() {return name;}

    public Zone(GoogleMap mMap, double latitude, double longitude, String name) {
        this.mMap = mMap;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.radius = calculateRadius();

    }

    //Creates radius based on marker position
    private Circle calculateRadius() {
        radius = mMap.addCircle(new CircleOptions()
                .center(new LatLng(latitude, longitude))
                .radius(50));
        radius.setVisible(false);
        return radius;
    }
}
