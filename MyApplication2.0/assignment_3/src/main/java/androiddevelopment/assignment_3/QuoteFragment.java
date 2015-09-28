package androiddevelopment.assignment_3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by J on 21/09/2015.
 */
public class QuoteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();

        ArrayList<String> quoteList = new ArrayList<>();

        Adapter adapter = new Adapter(c, quoteList);
        View v = inflater.inflate(R.layout.fragment_quote, container, false);
        ListView listView = (ListView)v.findViewById(R.id.listView);

        listView.setAdapter(adapter);

        return v;
    }
}
