package androiddevelopment.assignment_2;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * Created by J on 13/09/2015.
 */
public class MasterScreen extends Fragment {

    private ArrayList<Movie> mMovieList = new ArrayList<Movie>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();
        TypedArray mTypedMovieList = c.getResources().obtainTypedArray(R.array.movies);

        for (int i = 0; i < mTypedMovieList.length(); i++) {
            TypedArray mMovieSingle = c.getResources().obtainTypedArray(mTypedMovieList.getResourceId(i, 0));
            Movie movie = new Movie(mMovieSingle.getString(0),
                    mMovieSingle.getString(1),
                    mMovieSingle.getString(2),
                    mMovieSingle.getResourceId(3,0),
                    mMovieSingle.getResourceId(4,0));
            this.mMovieList.add(movie);
            mMovieSingle.recycle();
        }
        mTypedMovieList.recycle();

        Adapter adapter = new Adapter(c,this.mMovieList);
        View v = inflater.inflate(R.layout.master_screen, container, false);
        GridView grid = (GridView)v.findViewById(R.id.grid_view);

        grid.setAdapter(adapter);

        return v;
    }
}
