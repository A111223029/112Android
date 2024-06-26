package com.example.arrayadapterspinner_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner drink, temp;
    private TextView txv;

    // Define temperature sets
    private String[] tempSet1 = {"冰", "去冰", "温"}; // Three temperatures
    private String[] tempSet2 = {"冰", "去冰"}; // Two temperatures

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find and initialize the TextView
        txv = (TextView) findViewById(R.id.order);

        // Find and initialize the Spinners
        temp = (Spinner) findViewById(R.id.temp); // Spinner for temperature
        drink = (Spinner) findViewById(R.id.drink); // Spinner for drink

        // Set an OnItemSelectedListener for drink Spinner
        drink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Determine the temperature set based on the selected drink
                String[] tempSet;
                if (position == 3) { // If lemonade
                    tempSet = tempSet2;
                } else {
                    tempSet = tempSet1;
                }
                // Create ArrayAdapter for temperature spinner
                ArrayAdapter<String> tempAd =
                        new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        tempSet);

                // Set the dropdown view resource
                tempAd.setDropDownViewResource(
                        android.R.layout.simple_list_item_single_choice);
                temp.setAdapter(tempAd);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection if needed
            }
        });

        Button order = (Button) findViewById(R.id.btnOrder); // Find the order button
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = drink.getSelectedItem().toString()+", "+
                        temp.getSelectedItem().toString();
                txv.setText(msg);
            }
        });
    }
}