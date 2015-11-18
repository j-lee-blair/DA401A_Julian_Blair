package androiddevelopment.assignment_4;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkerClickFragment extends DialogFragment implements Dialog.OnClickListener{

    public MarkerClickFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        //You might have to create a class of Question here
        //make an array of the question objects here gotten from your MainActivty
        //CharSequence[] choiceList = {use your ArrayName.property, ArrayName.property};
        Bundle args = getArguments();

        //initialize String array with data from TypedArray
       /* String[] qList = new String[5];
        for (int i = 0; i < qList.length; i++) {
            qList[i] = questions.getString(i);
        }*/

        Log.i("MarkerClickFrag: ", "Getting Bundle...");
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setSingleChoiceItems(args.getStringArray("choices"), -1, null)
                .setTitle(args.getString("Title"))
                .setMessage(args.getString("Message"))
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel", this);
        Log.i("MarkerClickFrag: ", "Get Bundle complete");
        return dialog.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which){
            case Dialog.BUTTON_POSITIVE:
            break;
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);



    }
}
