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

    private ArrayList<Product> singleRow;
    private LayoutInflater thisInflater;

    public CustomAdapter(Context context, ArrayList<Product> aRow) {

        this.singleRow = aRow;
        thisInflater = ( LayoutInflater.from(context) );

    }


    //used to get how many items are in your array
    @Override
    public int getCount() {
        return singleRow.size();
    }

    //needs to return what position we are at in the array
    @Override
    public Object getItem(int position) {
        return singleRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // getView method is where most of the work is done
    // The Adapter is creating rows for us, and each row has an ImageView, and two TextViews

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = thisInflater.inflate(R.layout.list_view_product, parent, false);

            TextView theName = (TextView) convertView.findViewById(R.id.textName);
            TextView theDescription = (TextView) convertView.findViewById(R.id.textDescription);
            TextView thePrice = (TextView) convertView.findViewById(R.id.textPrice );
            ImageView theImage = (ImageView) convertView.findViewById(R.id.imageView);

            Product currentRow = (Product) getItem(position);

            theName.setText(currentRow.getName() );
            theDescription.setText(currentRow.getDescription() );

            double d = currentRow.getPrice();
            thePrice.setText( String.valueOf( d ) );
            thePrice. setText( "" + d + "€");

            theImage.setImageResource(currentRow.getBigImageName());
        }

        //convertView variable will hold all the rows for our ListView

        return convertView;
    }
}
