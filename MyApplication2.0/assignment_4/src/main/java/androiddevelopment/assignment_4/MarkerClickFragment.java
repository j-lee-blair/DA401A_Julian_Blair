package androiddevelopment.assignment_4;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Something")
                .setMessage("Something else")
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel",this);

        //This may crash the program

        return dialog.create();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which){
            case Dialog.BUTTON_POSITIVE:
            break;
        }
    }
}
