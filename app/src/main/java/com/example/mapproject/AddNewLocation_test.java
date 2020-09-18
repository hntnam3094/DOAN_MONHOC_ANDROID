package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewLocation_test extends AppCompatActivity {

    DatabaseHelper db;
    EditText edname, edtitle, edv1, edv2;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_location_test);
        db = new DatabaseHelper(this);
        db.createTable();
        edname = findViewById(R.id.edName);
        edtitle = findViewById(R.id.edtitle);
        edv1 = findViewById(R.id.edv1);
        edv2 = findViewById(R.id.edv2);
        btnadd = findViewById(R.id.btnadd);

       btnadd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name = edname.getText().toString();
               String title = edtitle.getText().toString();
               double v1 = Double.parseDouble(edv1.getText().toString());
               double v2 = Double.parseDouble(edv2.getText().toString());
               AddnewLocation(name,title,v1,v2);
           }
       });
    }

    void AddnewLocation(String name, String title, double v1, double v2){
        try {
            db.insertLocation(name,title, v1, v2);
            Toast.makeText(AddNewLocation_test.this,"Adding successfull", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(AddNewLocation_test.this, "Adding fail", Toast.LENGTH_SHORT).show();
        }
    }
}
