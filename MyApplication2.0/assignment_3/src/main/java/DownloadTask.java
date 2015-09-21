import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by J on 21/09/2015.
 */
public class DownloadTask extends AsyncTask<URL, void, List<Quote>> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<Quote> quoteList) {
        super.onPostExecute(quoteList);
    }

    @Override
    protected List<Quote> doInBackground(URL... params) {
        try{
            HttpURLConnection conn = (HttpURLConnection) params[0].openConnection();
            try{
                InputStream stream = new BufferedInputStream(conn.getInputStream());
                return createListOfQuotes(stream);
            }
            finally {
                conn.disconnect();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    //FANCY THING DON'T FORGET!!!
    //NAMEOFLIST.smoothScrollToPosition(LISTOFQUOTENAME.size() - 1);

    private List<Quote>createListOfQuotes(InputStream stream){
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

    return getQuoteList();//invoke a method that takes in json as a parameter and converts it to a list of books
                          //this list can then be returned from this method
    }

    private List<Quote>getQuoteList(JSONObject json) {
        List<Quote> qList = new List<Quote>();
        return qList;
    }

}
