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

    public Adapter(Context context, ArrayList<Movie>list){
        this.mMovieList = new ArrayList<>(list);
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

        ImageView img_L = (ImageView) convertView.findViewById(R.id.movie_image);
        TextView title= (TextView) convertView.findViewById(R.id.movie_title);
        TextView year = (TextView) convertView.findViewById(R.id.movie_year);

        Movie movie = (Movie) getItem(position);

        title.setText(movie.getmTitle());
        year.setText(movie.getmReleaseYear());
        img_L.setImageResource(movie.getmImage_L());

        return convertView;
    }
}
