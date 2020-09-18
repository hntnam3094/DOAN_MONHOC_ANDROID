package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Infomation_Location extends AppCompatActivity {

    DatabaseHelper db;
    EditText edName, edTitle;
    Button btnUpdate, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation__location);
        db = new DatabaseHelper(this);
        db.createTable();

        Intent i = getIntent();
        final int id = i.getIntExtra("ID",-1);
        final double v1 = i.getDoubleExtra("V1",-1);
        final double v2 = i.getDoubleExtra("V2",-1);


        edName = findViewById(R.id.edName_info2);
        edTitle = findViewById(R.id.edTitle_info2);

        edName.setText(i.getStringExtra("NAME").toString());
        edTitle.setText(i.getStringExtra("TITLE").toString());

        btnUpdate = findViewById(R.id.updateLocation);
        btnDelete = findViewById(R.id.deleteLocation);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String title = edTitle.getText().toString();
                Intent i = getIntent();
                if(db.UpdateLocation(id,name,title,v1,v2)>0)
                {
                    Toast.makeText(Infomation_Location.this,"Sửa thành công!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.deleteLocation_by_id(id)>0){
                    Toast.makeText(Infomation_Location.this,"Xóa thành công!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
