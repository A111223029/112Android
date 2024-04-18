package com.example.ch6_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.sax.TextElementListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgGender);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView output = (TextView) findViewById(R.id.lblOutput);
                switch (checkedId) {
                    case R.id.rdbBoy:
                        RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
                        output.setText((boy.getText()));
                        break;
                    case R.id.rdbGirl:
                        RadioButton girl = (RadioButton) findViewById(R.id.rdbGirl);
                        output.setText((girl.getText()));
                        break;
                }
            }
        });

    }
}