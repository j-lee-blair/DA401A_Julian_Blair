package androiddevelopment.assignment_2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * Created by J on 13/09/2015.
 */
public class MasterScreen extends Fragment {

    private List<Movie>mMovieList; //tror inte att detta behövs då jag har en StringArray istället


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context c = getContext();

        //På nästa rad försöker jag ladda in mina filmer till en array. movie_array innehåller dock
        // en blandning av info om filmen. Om jag skriver ut till konsol så får jag all info om
        // filmen. Hur ska jag kunna fp ut endast den info jag vill se utan att behöva gå in och
        // ändra i den stringen som returneras från xml-filen?

        String[] mMovieList = c.getResources().getStringArray(R.array.movie_array);

        Adapter adapter = new Adapter(c, mMovieList);

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
