package androiddevelopment.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class quoteFragment extends Fragment {

    public static quoteFragment newInstance(String param1, String param2) {
        quoteFragment fragment = new quoteFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("quoteFragment", "method call: view created");

        View v = inflater.inflate(R.layout.fragment_quote, container, false);

        return v;
    }
}
