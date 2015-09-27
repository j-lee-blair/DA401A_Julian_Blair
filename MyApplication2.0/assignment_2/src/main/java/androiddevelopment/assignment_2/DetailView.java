package androiddevelopment.assignment_2;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by J on 13/09/2015.
 */
public class DetailView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.detail_view, container, false);

        ImageView imageView = (ImageView) v.findViewById(R.id.movieImg);
        TextView textTitle = (TextView)v.findViewById(R.id.movie_title);
        TextView textYear = (TextView)v.findViewById(R.id.movie_year);
        TextView textDesc = (TextView)v.findViewById(R.id.movie_description);

        // Hämta bundle-objektet som skapades i föregående fragment / Isak
        Bundle args = getArguments();


        // Använda bundle objektet args för att hämta värden / Isak
        imageView.setImageResource(args.getInt("FanArt"));
        textTitle.setText(args.getString("Title"));
        textYear.setText(args.getString("Year"));
        textDesc.setText(args.getString("Description"));

        return v;
    }
}
