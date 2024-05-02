package com.example.checkboxdemo;

import static android.widget.CompoundButton.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.CanvasKt;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener {

    private  CheckBox original, beef, seafood;
    private int[] chkIDs = {R.id.chkOriginal, R.id.chkBeef, R.id.chkSeafood};
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         original = (CheckBox) findViewById(R.id.chkOriginal);
         beef = (CheckBox) findViewById(R.id.chkBeef);
         seafood = (CheckBox) findViewById(R.id.chkSeafood);

         for (int id:chkIDs){
             CheckBox chk = (CheckBox) findViewById(id);
             chk.setOnCheckedChangeListener(this);
         }

        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check which pizzas are selected


                String str = "";

                if (original.isChecked())
                    str += original.getText() + "\n";

                if (beef.isChecked())
                    str += beef.getText() + "\n";

                if (seafood.isChecked())
                    str += seafood.getText() + "\n";

                // Display the ordered items
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(str);
            }
        });

    }

    @Override
    public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {

        TextView txvStatus = (TextView) findViewById(R.id.txvStatus);
        TextView output = (TextView) findViewById(R.id.lblOutput);

        int id = buttonView.getId();

        String str = "";
        String status = "";

        if (id == R.id.chkOriginal) {
            status = (isChecked ? "選取" : "取消") + "原味...";
        } else if (id == R.id.chkBeef) {
            status = (isChecked ? "選取" : "取消") + "牛肉...";
        } else if (id == R.id.chkSeafood) {
            status = (isChecked ? "選取" : "取消") + "海鮮...";
        }

        txvStatus.setText(status);

        for (int i : chkIDs) {
            CheckBox chk = (CheckBox) findViewById(i);
            if (chk.isChecked())
                str += chk.getText() + "\n";
        }

        // 顯示訂購項目
        output.setText(str);
    }

}