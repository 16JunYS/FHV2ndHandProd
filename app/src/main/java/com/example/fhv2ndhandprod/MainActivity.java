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
    ArrayList<Product> myRowItems;



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


        Product product_one = new Product();
        product_one.setName("Blue armchair");
        product_one.setDescription("I sell my pre-owned armchair");
        product_one.setPrice(60);
        product_one.setSmallImageName(R.drawable.small_armchair);
        product_one.setBigImageName(R.drawable.big_armchair );
        myRowItems.add(product_one);

        Product product_two = new Product();
        product_two.setName("Seasonal bag");
        product_two.setDescription("I sell bag in good condition from PARFOIS");
        product_one.setPrice(35);
        product_two.setSmallImageName(R.drawable.small_bag);
        product_two.setBigImageName(R.drawable.big_bag);
        myRowItems.add(product_two);

        Product product_three = new Product();
        product_three.setName("Bike");
        product_three.setDescription("I sell second hand bicycle");
        product_one.setPrice(470);
        product_three.setSmallImageName(R.drawable.small_bike);
        product_three.setBigImageName( R.drawable.big_bike);
        myRowItems.add(product_three);

        Product product_four = new Product();
        product_four.setName("Microwave");
        product_four.setDescription("Samsung microwave");
        product_one.setPrice(80);
        product_four.setSmallImageName(R.drawable.small_microwave);
        product_four.setBigImageName(R.drawable.big_microwave);
        myRowItems.add(product_four);

        Product product_five = new Product();
        product_five.setName("Boots Hunter");
        product_five.setDescription("Red boots hunter");
        product_one.setPrice(56.50);
        product_five.setSmallImageName(R.drawable.small_boots);
        product_five.setBigImageName( R.drawable.big_boots );
        myRowItems.add(product_five);

        Toast.makeText(MainActivity.this, "Size:"+myRowItems.size(), Toast.LENGTH_SHORT).show();
    }

    /*public void TEMP_register(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }*/
}
