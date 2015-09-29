package androiddevelopment.assignment_3;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by J on 21/09/2015.
 */
public class QuoteFragment extends Fragment {

    ArrayList<String> quoteList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();

        quoteList = new ArrayList<>();

        Adapter adapter = new Adapter(c, quoteList);
        View v = inflater.inflate(R.layout.fragment_quote, container, false);
        ListView listView = (ListView) v.findViewById(R.id.listView);

        listView.setAdapter(adapter);

        return v;
    }

    private class DownloadTask extends AsyncTask<URL, ProgressBar, String> {

        ProgressBar pBar;

        public void SetProgressBar(ProgressBar bar){
            this.pBar = bar;
        }

        @Override
        protected void onProgressUpdate(ProgressBar... values) {
            super.onProgressUpdate(values);
            if(this.pBar !=null){
                pBar.setProgress(values[0]);
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String quote) {
            super.onPostExecute(quote);
        }

        @Override
        protected String doInBackground(URL... params) {
            try {
                HttpURLConnection conn = (HttpURLConnection) params[0].openConnection();
                try {
                    InputStream stream = new BufferedInputStream(conn.getInputStream());
                    return getQuote(stream);
                } finally {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //FANCY THING DON'T FORGET!!!

        //NAMEOFLIST.smoothScrollToPosition(LISTOFQUOTENAME.size() - 1);

        private String getQuote(InputStream stream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return line;//invoke a method that takes in json as a parameter and converts it to a list of book
            // this list can then be returned from this method
        }

    }
}