package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button and set an OnClickListener
        Button btnConfirm = (Button) findViewById(R.id.button);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Find the Spinner
                Spinner sp = (Spinner) findViewById(R.id.spinner);
                // Get the selected item position
                int index = sp.getSelectedItemPosition();

                // Find the TextView
                TextView output = (TextView) findViewById(R.id.lblOutput);
                // Set the text based on the selected item
                // String[] steaks = getResources().getStringArray(R.array.steaks);
                // output.setText("牛小排+ steaks[index]);
                output.setText("牛排要" + sp.getSelectedItem().toString());
            }
        });
    }

}