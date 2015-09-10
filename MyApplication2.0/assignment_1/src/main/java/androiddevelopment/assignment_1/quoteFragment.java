package androiddevelopment.assignment_1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;


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
        TextView quote = (TextView) v.findViewById(R.id.textView_Quote);

        quote.setText(Helpers.getQuote(this.getContext()));
        TextView date = (TextView)v.findViewById(R.id.textView_Date);

        Date d = new Date();
        String theDate = DateFormat.getDateInstance().format(new Date());
        date.setText(theDate);

        return v;
    }
}
