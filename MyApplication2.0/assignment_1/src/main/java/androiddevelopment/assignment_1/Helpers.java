package androiddevelopment.assignment_1;

/**
 * Created by J on 03/09/2015.
 */

import android.content.Context;
import java.util.Random;

public class Helpers {

    public static String getQuote(Context context){
        String [] qArray;
        Random r;

        qArray = context.getResources().getStringArray(R.array.quotes_array);
        r = new Random();

        int next = r.nextInt(qArray.length);

        return qArray[next];
    }
}