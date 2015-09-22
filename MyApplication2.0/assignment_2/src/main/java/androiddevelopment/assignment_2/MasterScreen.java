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

    private ArrayList<Movie> mMovieList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();

        TypedArray mMovieList = c.getResources().obtainTypedArray(R.array.movies);


        //Här lägger loopar jag igenom en 2 dimensionell array (kan man säga) och skapar movie objekt
        //Men det står att mitt objekt är null efter att jag skapat den, så det gåt inte att lägga
        //till det objektet i Arraylist<Movie> ...
        for (int i = 0; i < mMovieList.length(); i++) {
            TypedArray mMovieSingle = c.getResources().obtainTypedArray(mMovieList.getResourceId(i,0));
            Movie movie = new Movie(mMovieSingle.getString(0),
                    mMovieSingle.getString(1),
                    mMovieSingle.getString(2),
                    mMovieSingle.getResourceId(3,0), //här triggades först error innan. Då använde jag
                                                     //getInt(3) istället dock
                    mMovieSingle.getResourceId(4,0)

            ); //Nu ska jag ha ett movieObjekt.

            //nu vill jag lägga till den i min vanliga ArrayList<Movie> som är en instansvariabel
            this.mMovieList.add(movie);

            //försöker kolla ifall det gick här men kommer inte hit ännu pga errors
            Movie m = this.mMovieList.get(0);
            Log.i("MasterScreen: ", movie.getTitle());
        }

        Adapter adapter = new Adapter(c,this.mMovieList);
        View v = inflater.inflate(R.layout.master_screen, container, false);
        GridView grid = (GridView)v.findViewById(R.id.grid_view);

        grid.setAdapter(adapter);

        return v;
    }
}
