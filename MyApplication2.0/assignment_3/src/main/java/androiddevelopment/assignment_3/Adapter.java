package androiddevelopment.assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by J on 21/09/2015.
 */
public class Adapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mQuoteList;
    private LayoutInflater mInflater;

    public Adapter(Context c, ArrayList<String> quoteList) {
        this.mContext = c;
        this.mQuoteList = quoteList;
        this.mInflater = LayoutInflater.from(this.mContext);
    }


    @Override
    public int getCount() {return mQuoteList.size();}

    @Override
    public String getItem(int position) {return mQuoteList.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fragment_quote, parent, false);
        }

        TextView textViewText = (TextView) convertView.findViewWithTag(R.string.quote_text);

        String text = getItem(position);

        textViewText.setText(text);

        return convertView;
    }
}
