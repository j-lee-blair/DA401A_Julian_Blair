package androiddevelopment.assignment_4;

import android.util.Log;

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
    private String message;
    private String[]choices;


    public String getMessage() {return message;}
    public String[] getChoices() {return choices;}
    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public Circle getCircle() {return radius;}
    public String getName() {return name;}

    public Zone(GoogleMap mMap, double latitude, double longitude, String name, String message, Question q ) {
        this.choices = new String[3];
        this.mMap = mMap;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.message = message;
        this.choices = q.getList();
        this.radius = calculateRadius();
        check();
    }

    private void check(){
        for (int i = 0; i < choices.length; i++) {
            Log.i("Choices Array:", choices[i]);
        }
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
