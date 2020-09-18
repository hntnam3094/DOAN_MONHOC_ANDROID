package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ListLocation extends AppCompatActivity {

    DatabaseHelper db;
    RecyclerView recyclerView;
    Location_Adapter location_adapter;
    ArrayList<Location> locationArrayList;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_location);
        db = new DatabaseHelper(this);
        db.createTable();
        btnAdd = findViewById(R.id.btnAddLocation);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        locationArrayList = db.fetch_ListLocation();
        location_adapter = new Location_Adapter(this, locationArrayList);
        recyclerView.setAdapter(location_adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Location location = locationArrayList.get(position);
                Intent i = new Intent(ListLocation.this, MapActivity.class);
                i.putExtra("ID",location.getId());
                i.putExtra("NAME", location.getName());
                i.putExtra("TITLE", location.getTitle());
                i.putExtra("V1", location.getV1());
                i.putExtra("V2", location.getV2());
                startActivity(i);
                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Location location = locationArrayList.get(position);
                Intent i = new Intent(ListLocation.this, Infomation_Location.class);
                i.putExtra("ID",location.getId());
                i.putExtra("NAME", location.getName());
                i.putExtra("TITLE", location.getTitle());
                i.putExtra("V1", location.getV1());
                i.putExtra("V2", location.getV2());
                startActivity(i);
            }
        }));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListLocation.this, AddNewLocation_test.class));
            }
        });
    }

}
