package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSave,btnLoad;
    EditText txtName, txtAge;

    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);

        //save data button action
        btnSave.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get values name and age
                name =  txtName.getText().toString();
                age = Integer.parseInt(txtAge.getText().toString());

                SharedPreferences prf = getSharedPreferences("details",MODE_PRIVATE);
                SharedPreferences.Editor editor = prf.edit();
                editor.putString("name",name);
                editor.putInt("age",age);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();

            }
        }));
        //load data button action
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get value from SharedPreferences
                SharedPreferences prf = getSharedPreferences("details",MODE_PRIVATE);

                String name = prf.getString("name","no name");
                int age = prf.getInt("age",0);

                Toast.makeText(getApplicationContext(), "Your Name :"+name+"Your Age"+age, Toast.LENGTH_SHORT).show();
            }
        });
    }
}