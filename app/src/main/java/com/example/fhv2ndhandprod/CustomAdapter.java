package com.example.fhv2ndhandprod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<RowItem> singleRow;
    private LayoutInflater thisInflater;

    public CustomAdapter(Context context, ArrayList<RowItem> aRow) {

        this.singleRow = aRow;
        thisInflater = ( LayoutInflater.from(context) );

    }


    //used to get how many items are in your array
    @Override
    public int getCount() {
        return 0;
    }

    //needs to return what position we are at in the array
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // getView method is where most of the work is done
    // The Adapter is creating rows for us, and each row has an ImageView, and two TextViews

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = thisInflater.inflate(R.layout.list_view_row, null );

            TextView theHeading = (TextView) convertView.findViewById(R.id.textHeading);
            TextView theSubHeading = (TextView) convertView.findViewById(R.id.textSubHeading);
            ImageView theImage = (ImageView) convertView.findViewById(R.id.imageView);

            RowItem currentRow = (RowItem) getItem(position);

            theHeading.setText(currentRow.getHeading() );
            theSubHeading.setText(currentRow.getSubHeading() );
            theImage.setImageResource(currentRow.getBigImageName());

        }

        //convertView variable will hold all the rows for our ListView

        return convertView;
    }
}
