package androiddevelopment.assignment_2;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * Created by J on 13/09/2015.
 */
public class MasterScreen extends Fragment {

    private ArrayList<Movie> mMovieList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();

        TypedArray mMovieList = c.getResources().obtainTypedArray(R.array.movies);

        for (int i = 0; i < mMovieList.length(); i++) {
            TypedArray mMovieSingle = c.getResources().obtainTypedArray(mMovieList.getResourceId(i,0));
            Movie movie = new Movie(mMovieSingle.getString(2),mMovieSingle.getInt(4,0), mMovieSingle.getInt(3,0), mMovieSingle.getString(1), mMovieSingle.getString(0));
            this.mMovieList.add(movie);
        }



        Adapter adapter = new Adapter(c,this.mMovieList);
        View v = inflater.inflate(R.layout.master_screen, container, false);
        GridView grid = (GridView)v.findViewById(R.id.grid_view);

        //Här kopplar jag min adapter till min gridview. Det nämndes att man skulla loop igneom någonting
        //jag antar att det är en metod i adaptern men jag vet inte riktigt varför så svårt att
        // greppa poängen.
        grid.setAdapter(adapter);

        return v;

        //Här returnerar jag min view. Om jag tar bort raden alla referenser till Adaptern så
        //set jag fortfarande inte min gridview (jag kunde se den innan fast den var tom).
    }
}
