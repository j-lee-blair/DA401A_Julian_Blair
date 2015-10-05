package androiddevelopment.assignment_3;

import android.content.Context;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by J on 21/09/2015.
 */
public class QuoteFragment extends Fragment implements View.OnClickListener{

    private ArrayList<String> quoteList;
    private ProgressBar pBar; //this belongs to the fragment so finding it with View only works
                              //in this class
    private String TAG = "QuoteFragment";
    private ListView listView;
    private Adapter adapter;
    private TextView textView;
    private String quote;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();
        quoteList = new ArrayList<>();
        adapter = new Adapter(c, quoteList);
        View view = inflater.inflate(R.layout.fragment_quote, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        textView = (TextView) view.findViewWithTag(R.string.quote_text);
        listView.smoothScrollToPosition(quoteList.size() -1);

        FloatingActionButton btn = (FloatingActionButton)view.findViewById(R.id.mFloatingActionBar);
        this.pBar = (ProgressBar) view.findViewById(R.id.mProgressBar);

        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "click heard!");
            URL url = null;
            try {
                Log.i(TAG, "Try create URL");
                url = new URL("https://api.github.com/zen?access_token=d793d7ad4c8b8483fc7fb9a2d4d761dedc1ba815");
            } catch (MalformedURLException e) {
                Log.i(TAG, "URL creation error");
                e.printStackTrace();
            }
            Log.i(TAG, "Try create DownloadTask");
            new DownloadTask(this.pBar, this.textView).execute(url);
            Log.i(TAG, "DownloadTask creation success");
    }

    private class DownloadTask extends AsyncTask<URL, ProgressBar, String> {

        private ProgressBar pBar;
        private TextView textView;
        private String TAG = "DownloadTask";

        public DownloadTask(ProgressBar pBar, TextView textView){
            this.pBar = pBar;
            this.textView = textView;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(this.pBar !=null){
                Log.i(this.TAG, "Try set pBar visibility");
                View view = getView();
                pBar.setVisibility(view.VISIBLE);
                Log.i(this.TAG, "pBar visibilty set");
            }
        }

        @Override
        protected void onPostExecute(String quote) {
            super.onPostExecute(quote);
            quoteList.add(quote);

            if(this.pBar !=null){
                View view = getView();
                Log.i(this.TAG, "Try set pBar visibility");
                pBar.setVisibility(view.INVISIBLE);
                Log.i(this.TAG, "pBar invisibiltiy set");

                Log.i(this.TAG, "try set listView item text");

                textView.setText(quote);
                listView.setAdapter(adapter);
            }
        }

        @Override
        protected String doInBackground(URL... params) {
            try {
                HttpURLConnection conn = (HttpURLConnection) params[0].openConnection();
                try {
                    Log.i(this.TAG, "Attempting to get stream");
                    InputStream stream = new BufferedInputStream(conn.getInputStream());
                    Log.i(this.TAG, "Get stream success");
                    return getQuote(stream);
                } finally {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(this.TAG, "Get stream failed");
            }
            return null;
        }


        private String getQuote(InputStream stream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                Log.i(this.TAG, "Try read data from stream");
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i(this.TAG, "read data from stream success");
            return line;//invoke a method that takes in json as a parameter and converts it to a list of book
                        // this list can then be returned from this method
        }
    }
}