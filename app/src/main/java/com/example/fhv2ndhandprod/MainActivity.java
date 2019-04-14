package com.example.fhv2ndhandprod;


import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayList<RowItem> myRowItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRowItems = new ArrayList();

        myListView = (ListView) findViewById(R.id.productListView);

        fillArrayList();

        CustomAdapter myAdapter = new CustomAdapter(this, myRowItems);

        myListView.setAdapter(myAdapter);

    }

    private void fillArrayList() {


        RowItem row_one = new RowItem();
        row_one.setHeading("Blue armchair");
        row_one.setSubHeading("I sell my pre-owned armchair");
        row_one.setSmallImageName(R.drawable.small_armchair);
        row_one.setBigImageName(R.drawable.big_armchair );
        myRowItems.add(row_one);

        RowItem row_two = new RowItem();
        row_two.setHeading("Seasonal bag");
        row_two.setSubHeading("I sell bag in good condition from PARFOIS");
        row_two.setSmallImageName(R.drawable.small_bag);
        row_two.setBigImageName(R.drawable.big_bag);
        myRowItems.add(row_two);

        RowItem row_three = new RowItem();
        row_three.setHeading("Bike");
        row_three.setSubHeading("I sell second hand bicycle");
        row_three.setSmallImageName(R.drawable.small_bike);
        row_three.setBigImageName( R.drawable.big_bike);
        myRowItems.add(row_three);

        RowItem row_four = new RowItem();
        row_four.setHeading("Microwave");
        row_four.setSubHeading("Samsung microwave");
        row_four.setSmallImageName(R.drawable.small_microwave);
        row_four.setBigImageName( R.drawable.big_microwave);
        myRowItems.add(row_four);

        RowItem row_five = new RowItem();
        row_five.setHeading("Boots Hunter");
        row_five.setSubHeading("Red boots hunter");
        row_five.setSmallImageName(R.drawable.small_boots);
        row_five.setBigImageName( R.drawable.big_boots );
        myRowItems.add(row_five);

        Toast.makeText(MainActivity.this, "Size:"+myRowItems.size(), Toast.LENGTH_SHORT).show();
    }

    /*public void TEMP_register(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }*/
}
