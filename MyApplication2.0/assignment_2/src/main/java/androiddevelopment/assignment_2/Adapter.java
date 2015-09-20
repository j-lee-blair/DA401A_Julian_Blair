package androiddevelopment.assignment_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by J on 13/09/2015.
 */
public class Adapter extends BaseAdapter {

    private ArrayList<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public Adapter(Context context, String[]list){
        this.mMovieList = new ArrayList<>();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }


    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.grid_item_layout, parent, false);
        }

        //THE BELOW NEEDS TO WORK FOR US TO SEE THE ITEMS IN A GRID

        ImageView img = (ImageView) convertView.findViewById(R.id.movie_image);
        TextView title= (TextView) convertView.findViewById(R.id.movie_title);
        TextView year = (TextView) convertView.findViewById(R.id.movie_year);

        //Förstår inte vad nästa rad är till för. Om man skapar ett objekt av movie måste
        //man kunna initiera den med info från mMovieList tänker jag men jag har problem
        //med att få ut datan då den är blandad med en massa annat som en stor string.

        Movie movie = (Movie) getItem(position);

        title.setText(movie.getmTitle()); //detta kommer endast fungera om objektet är initierat
        year.setText(movie.getmReleaseYear()); //samma här
        //Jag vet inte hur jag ska 'set' img. Fast det ligger en referens i mMovieList ... men
        //fattar inte hur jag ska komma åt den på ett smidigt sätt.

        return convertView;
    }
}
