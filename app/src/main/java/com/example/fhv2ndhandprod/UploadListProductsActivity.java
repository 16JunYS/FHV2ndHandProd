package com.example.fhv2ndhandprod;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UploadListProductsActivity extends ArrayAdapter<Product> {

// two private fields at the top because we need methods
// inside the class to access the context and the list of products

    private Context context;
    private List<Product> sellProducts;

    //constructor
    public UploadListProductsActivity(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.sellProducts = objects;
    }
    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //Since we have access to the position of the element rendered
        //we can get this element from the array list of product objects

        Product product = sellProducts.get(position);
        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_upload_product, null);

        //Changed TextView to EditText, new GUI
        EditText description = (EditText) view.findViewById(R.id.productNameEditText);
        EditText address = (EditText) view.findViewById(R.id.productDescriptionEditText);

        return view;
    }
}
