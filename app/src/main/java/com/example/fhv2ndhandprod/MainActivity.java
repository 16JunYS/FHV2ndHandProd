package com.example.fhv2ndhandprod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //so that every method inside this class can access to it:
    private ArrayList<Product> sellProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //create our new array adapter
    ArrayAdapter<Product> adapter = new UploadListProductsActivity(this, 0, sellProducts);
}
