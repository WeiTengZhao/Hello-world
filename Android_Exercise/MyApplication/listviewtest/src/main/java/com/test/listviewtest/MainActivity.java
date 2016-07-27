package com.test.listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Location> locationList = new ArrayList<Location>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniLocation();
        LocationAdapter adapter = new LocationAdapter(MainActivity.this,R.layout.location_item,locationList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Location location = locationList.get(i);
                Toast.makeText(MainActivity.this,location.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void iniLocation() {
        Location l0 = new Location("岛风", R.mipmap.ic_launcher);
        locationList.add(l0);
        Location l1 = new Location("AMD",R.mipmap.ic_launcher);
        locationList.add(l1);
        Location l2 = new Location("Novida",R.mipmap.ic_launcher);
        locationList.add(l2);
        Location l3 = new Location("岛风",R.mipmap.ic_launcher);
        locationList.add(l3);
        Location l4 = new Location("AMD",R.mipmap.ic_launcher);
        locationList.add(l4);
        Location l5 = new Location("Novida",R.mipmap.ic_launcher);
        locationList.add(l5);
    }
}
