package fr.myschool.geekquote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import fr.myschool.geekquote.R;
import fr.myschool.geekquote.model.Quote;

public class QuotesAdapter extends ArrayAdapter<Quote> {
    int res;

    public QuotesAdapter(Context context, int resource, ArrayList<Quote> quotes) {
        super(context, resource, quotes);
        this.res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Quote quote = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        convertView = LayoutInflater.from(getContext()).inflate(this.res, parent, false);
        // Lookup view for data population
        LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll_qi_main);
        if(getPosition(quote) % 2 == 0) {
            ll.setBackgroundColor(getContext().getResources().getColor(R.color.clr_bg_odd));
        } else {
            ll.setBackgroundColor(getContext().getResources().getColor(R.color.clr_bg_even));
        }
        TextView tvStr = (TextView) convertView.findViewById(R.id.tv_qi_strquote);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_qi_date);
        TextView tvRating = (TextView) convertView.findViewById(R.id.tv_qi_rating);
        // Populate the data into the template view using the data object
        tvStr.setText(quote.getStrQuote());
        tvDate.setText(quote.getDate().toString());
        tvRating.setText(quote.getRating() + "");
        // Return the completed view to render on screen
        return convertView;
    }
}
