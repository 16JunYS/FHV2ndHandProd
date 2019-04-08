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

        myListView = (ListView) findViewById(R.id.flagListView);

        fillArrayList();

        CustomAdapter myAdapter = new CustomAdapter(this, myRowItems);

        myListView.setAdapter(myAdapter);

    }

    private void fillArrayList() {


        RowItem row_one = new RowItem();
        row_one.setHeading("Flag of France");
        row_one.setSubHeading("France");
        row_one.setSmallImageName(R.drawable.small_france);
        row_one.setBigImageName(R.drawable.big_france );
        myRowItems.add(row_one);

        RowItem row_two = new RowItem();
        row_two.setHeading("Flag of Italy");
        row_two.setSubHeading("Italy");
        row_two.setSmallImageName(R.drawable.small_italy);
        row_two.setBigImageName(R.drawable.big_italy);
        myRowItems.add(row_two);

        RowItem row_three = new RowItem();
        row_three.setHeading("Flag of Germany");
        row_three.setSubHeading("Germany");
        row_three.setSmallImageName(R.drawable.small_germany);
        row_three.setBigImageName( R.drawable.big_germany);
        myRowItems.add(row_three);

        RowItem row_four = new RowItem();
        row_four.setHeading("Flag of Sweden");
        row_four.setSubHeading("Sweden");
        row_four.setSmallImageName(R.drawable.small_sweden);
        row_four.setBigImageName( R.drawable.big_sweden);
        myRowItems.add(row_four);

        RowItem row_five = new RowItem();
        row_five.setHeading("Flag of Romania");
        row_five.setSubHeading("Romania");
        row_five.setSmallImageName(R.drawable.small_romania);
        row_five.setBigImageName( R.drawable.big_romania );
        myRowItems.add(row_five);

        Toast.makeText(MainActivity.this, "Size:"+myRowItems.size(), Toast.LENGTH_SHORT).show();
    }

    /*public void TEMP_register(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }*/
}
