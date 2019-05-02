package com.example.c347_p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyGradeAdapter extends ArrayAdapter {

    private ArrayList<DailyGrade> alDailyGrade;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;

    public DailyGradeAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
        super(context, resource, objects);
        // Store the data that is passed to this adapter
        alDailyGrade = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek =         rowView.findViewById(R.id.tvWeek);
        tvGrade =         rowView.findViewById(R.id.tvGrade);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyGrade current = alDailyGrade.get(position);
        // Set the TextView to show the food

        tvWeek.setText(current.getWeek());
        tvGrade.setText(current.getGrade());

        // Return the nicely done up View to the ListView
        return rowView;
    }

}
