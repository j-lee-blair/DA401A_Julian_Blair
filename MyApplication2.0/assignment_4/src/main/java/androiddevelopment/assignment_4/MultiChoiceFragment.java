package androiddevelopment.assignment_4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by J on 29/10/2015.
 */
public class MultiChoiceFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fragment dialog = new MultiChoiceFragment();
        View v = inflater.inflate(R.layout.multi_choice_fragment, container, false);

        //getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, dialog).commit();

        return v;


        //return super.onCreateView(inflater, container, savedInstanceState);



    }


}
