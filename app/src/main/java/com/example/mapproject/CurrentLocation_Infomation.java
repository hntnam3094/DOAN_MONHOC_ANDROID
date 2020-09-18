package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CurrentLocation_Infomation extends AppCompatActivity {

    EditText edName, edTitle;
    Button btnAddcurrent;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location__infomation);
        db = new DatabaseHelper(this);
        db.createTable();
        edName = findViewById(R.id.edName_info);
        edTitle = findViewById(R.id.edTitle_infp);
        btnAddcurrent = findViewById(R.id.btnAddCurrentLocation);
        btnAddcurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String title = edTitle.getText().toString();
                Intent i = getIntent();
                double v1 = i.getDoubleExtra("V1",-1);
                double v2 = i.getDoubleExtra("V2",-1);
                db.insertLocation(name,title, v1,v2);
                finish();
            }
        });
    }
}
