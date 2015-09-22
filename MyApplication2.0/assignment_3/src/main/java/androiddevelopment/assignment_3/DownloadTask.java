package androiddevelopment.assignment_3;

import java.lang.reflect.Array;
import java.net.URL;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import org.json.JSONObject;
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
public class DownloadTask extends AsyncTask<URL, ProgressBar, String> {

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
        try{
            HttpURLConnection conn = (HttpURLConnection) params[0].openConnection();
            try{
                InputStream stream = new BufferedInputStream(conn.getInputStream());
                return getQuote(stream);
            }
            finally {
                conn.disconnect();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    //FANCY THING DON'T FORGET!!!
    //NAMEOFLIST.smoothScrollToPosition(LISTOFQUOTENAME.size() - 1);

    private String getQuote(InputStream stream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try{
            while((line = reader.readLine()) != null){
                    sb.append(line);
                }
            }
        catch(IOException e){
            e.printStackTrace();
        }

    return line;//invoke a method that takes in json as a parameter and converts it to a list of book
                // this list can then be returned from this method
    }

}
