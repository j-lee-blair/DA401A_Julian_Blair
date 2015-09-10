package androiddevelopment.assignment_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class button_Fragment extends Fragment implements View.OnClickListener {

    public button_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("button_Fragment", "btn_Frag created");

        View v = inflater.inflate(R.layout.fragment_button, container, false);
        View btn_View = v.findViewById(R.id.btn_Get);
        btn_View.setOnClickListener(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        Log.i("button_Fragment", "Click\nSource: button_Fragment");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container, new quoteFragment());
        ft.addToBackStack(null);
        ft.commit();
    }
}
