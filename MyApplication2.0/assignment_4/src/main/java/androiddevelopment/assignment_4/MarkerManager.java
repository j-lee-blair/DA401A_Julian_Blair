package androiddevelopment.assignment_4;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;

public class MarkerManager {

    ArrayList<MarkerOptions> markerList;

    public ArrayList<MarkerOptions> getList(){
        return this.markerList;
    }

    public MarkerManager(){
        this.markerList = new ArrayList<>();
        initMarkers();
    }

    //Sets marker options
    private void initMarkers(){

        LatLng school = latLing(55.6087972, 12.9933342); //for school tests
        LatLng home = latLing(55.592958, 13.003435);
        LatLng bridge1 = latLing(55.606971, 12.996221);
        LatLng lilatorg = latLing(55.6045782, 12.9973829);
        LatLng bridge2 = latLing(55.5998191, 12.9996838);
        LatLng church = latLing(55.5936636, 13.002097);
        LatLng test = latLing(55.610007, 12.997174);

        markerList.add(new MarkerOptions()
                .position(school)
                .title("Niagara")
                .snippet("this is where I study")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.source)
                ));
        markerList.add(new MarkerOptions()
                .position(bridge1)
                .title("School Bridge")
                .snippet("This is where I nearly die everyday")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.agent)
                ));
        markerList.add(new MarkerOptions()
                .position(lilatorg)
                .title("lilla torg(ish)")
                .snippet("This is where I get hungry for vietnamese sandwiches")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bug)
                ));
        markerList.add(new MarkerOptions()
                .position(bridge2)
                .title("Slussen")
                .snippet("This is where I get stared at on the boat")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.briefcase)
                ));
        markerList.add(new MarkerOptions()
                .position(home)
                .title("Home")
                .snippet("This is where I go to sleep at night")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.home)
                ));
        markerList.add(new MarkerOptions()
                .position(church)
                .title("Church")
                .snippet("This is where the mission starts")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.trinity)
                ));
        markerList.add(new MarkerOptions()
                .position(test)
                .title("PostKontoret")
                .snippet("")
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.home)
                ));
    }

    private LatLng latLing(double lat, double lng){
        LatLng latLing;
        return latLing = new LatLng(lat, lng);
    }

}
