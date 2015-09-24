package androiddevelopment.myapplication;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.util.ArraySet;

import java.util.List;


public class MainActivity extends  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = getResources().getStringArray(R.array.quotes_array);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity_main", "method call: started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity_main", "method call: resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity_main", "method call: paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity_main", "method call: destroyed");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
