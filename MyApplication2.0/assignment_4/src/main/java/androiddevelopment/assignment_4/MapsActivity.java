package androiddevelopment.assignment_4;

import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener,
GoogleApiClient.ConnectionCallbacks, com.google.android.gms.location.LocationListener{

    private GoogleApiClient mGoogleClient;
    private GoogleMap mMap;
    private ZoneManager zoneManager;
    private Bundle mBundle;
    private Context c;
    private TypedArray array;

    @Override
    public boolean onMarkerClick(Marker marker) {

        //if this is returned to true then the default behaviour of the marker click can be changed
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MarkerClickFragment mDialog = new MarkerClickFragment();
        mDialog.setArguments(mBundle);
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

        Context c = getApplicationContext();
        zoneManager = new ZoneManager(mMap,c);
        Log.i("ZoneManager: ", "ZoneList count: " + zoneManager.getZoneList().size());
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
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        UiSettings settings = mMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setMyLocationButtonEnabled(true);

        Log.i("Main: ", "1");

        MarkerManager mgr = new MarkerManager();
        Log.i("Main: ", "2");
        ArrayList<MarkerOptions> markerList = new ArrayList<>(mgr.getList());

        for (int i = 0; i < markerList.size(); i++){
            Log.i("Main:", "List position " + i + ": " + markerList.get(i).getTitle());
        }

        Log.i("Main: ", "3");

        LatLng home = markerList.get(1).getPosition();
        Log.i("Main: ", "4");

        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        Log.i("Main: ", "5");
        Location myLocation = mMap.getMyLocation();

        Log.i("Main: ", "6");
        setMarkers(markerList);

        Log.i("Main: ", "7");
        mMap.setOnMarkerClickListener(this);
        Log.i("Main: ", "finish");
    }

    private void setMarkers(ArrayList<MarkerOptions> list){
        for(int i = 0; i < list.size(); i++){
            mMap.addMarker(list.get(i));
        }

        Log.i("setMarker:", "Markers Set");
    }


    @Override
    public void onLocationChanged(Location location) {
        Log.i("MainActivity", "Location:" + location.getLongitude() + "time" + location.getTime());

        InZone isInZone = zoneManager.locationIsWithinZone(location);

        if(isInZone !=null){
            Zone zone = isInZone.getZone();
            Toast.makeText(MapsActivity.this, "You are now in zone: " + zone.getName(), Toast.LENGTH_SHORT).show();
            setBundle(zone);
        }
        else Toast.makeText(MapsActivity.this, "Listening... ", Toast.LENGTH_SHORT).show();
    }

    private void setBundle(Zone z){
        mBundle = new Bundle();
        mBundle.putString("Title", z.getName());
        mBundle.putString("Message", z.getMessage());
        mBundle.putStringArray("Choices", z.getChoices());

        for (int i = 0; i < mBundle.getStringArray("choices").length ; i++) {
            Log.i("bundle array:", mBundle.getStringArray("choices")[i]);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGoogleClient.disconnect();
    }

}
