package androiddevelopment.assignment_4;

import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.List;

public class ZoneManager {

    ArrayList<Zone> zoneList;
    ArrayList<Question> qList;

    public ArrayList<Zone> getZoneList() {
        return zoneList;
    }
    ZoneManager(GoogleMap mMap, Context c) {
        this.zoneList = new ArrayList<>();
        this.qList = new ArrayList<>();
        initZoneList(mMap, c);
    }
    private void initZoneList(GoogleMap mMap, Context c) {

        getSeperateQuestion(c);

        this.zoneList.add(new Zone(mMap, 55.6087972, 12.9933342, "School", "This is the source, you must enter it", this.qList.get(4)));
        this.zoneList.add(new Zone(mMap, 55.606971, 12.996221, "Bridge1", "You must take this to the source", this.qList.get(1)));
        this.zoneList.add(new Zone(mMap, 55.6045782, 12.9973829, "Lillatorg(ish)", "There is a glitch in the matrix", this.qList.get(2)));
        this.zoneList.add(new Zone(mMap, 55.5998191, 12.9996838, "Bridge2", "You must defeat the agent", this.qList.get(3)));
        this.zoneList.add(new Zone(mMap, 55.5936636, 13.002097, "Church", "Hello Neo, the matrix is real", this.qList.get(0)));
        this.zoneList.add(new Zone(mMap, 55.592958, 13.003435, "Home", null, this.qList.get(0)));
        this.zoneList.add(new Zone(mMap, 55.610007, 12.997174, "TestTitle", "When was the PostKontoret built?", this.qList.get(0)));

        Log.i("InitZoneList", "Method Finished");
    }
    private void getSeperateQuestion(Context c){
        Question q;
        TypedArray questionArray = c.getResources().obtainTypedArray(R.array.all);

        for (int i = 0; i < questionArray.length() ; i++) {

            TypedArray singleQuestion = c.getResources().obtainTypedArray((questionArray.getResourceId(i, 0)));
            q = new Question(singleQuestion.getString(0), singleQuestion.getString(1), singleQuestion.getString(2));
            this.qList.add(q);
            singleQuestion.recycle();

        }

        Log.i("ZoneManager qList:", String.valueOf(qList.size()));
        questionArray.recycle();
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