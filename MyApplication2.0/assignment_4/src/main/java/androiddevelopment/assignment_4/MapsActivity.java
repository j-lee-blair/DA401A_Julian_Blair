package androiddevelopment.assignment_4;

import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener,
GoogleApiClient.ConnectionCallbacks, com.google.android.gms.location.LocationListener{

    GoogleApiClient mGoogleClient;
    private GoogleMap mMap;

    @Override
    public boolean onMarkerClick(Marker marker) {

        //if this is returned to true then the default behaviour of the marker click can be changed
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MarkerClickFragment mDialog = new MarkerClickFragment();
        mDialog.show(ft, "dialog");

        return false; //the default behaviour will happen if this is false
    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.i("MainActivity:", "Connected");

        LocationRequest request = new LocationRequest();
        request.setInterval(10000);
        request.setFastestInterval(5000);
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleClient, request, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mGoogleClient = new GoogleApiClient.Builder(this)
        .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .build();

        mGoogleClient.connect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        UiSettings settings = mMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setMyLocationButtonEnabled(true);
        LatLng school = new LatLng(55.6091033,12.9938554);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(school));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        Location myLocation = mMap.getMyLocation();

        //THIS IS A OOP BUILD PATTERN INSTEAD OF USING CONSTRUCTORS
        mMap.addMarker(new MarkerOptions()
                .position(school)
                .title("Niagara")
                .snippet("this is where I study how to become a grownup")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.enter_the_matrix_web)
        ));

        //Listener
        mMap.setOnMarkerClickListener(this);
    }


    @Override
    public void onLocationChanged(Location location) {
        Log.i("MainActivity", "Location:" + location.getLongitude() + "time" + location.getTime());
    }
}
