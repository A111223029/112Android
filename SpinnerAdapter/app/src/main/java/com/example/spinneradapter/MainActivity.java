package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] courses,desserts;
    private Spinner spCourses,spDesserts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spCourses = (Spinner) findViewById(R.id.spinner);
        spDesserts = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adaCourses = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item,courses);
        ArrayAdapter<String> adaDesserts = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,desserts);

        spCourses.setAdapter(adaCourses);
        spDesserts.setAdapter((adaDesserts));

        Button btnConfirm = (Button) findViewById(R.id.button);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courses = spCourses.getSelectedItem().toString();
                String desserts = spDesserts.getSelectedItem().toString();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("主餐："+ courses + "\n甜點：" + desserts);
            }
        });
    }
}