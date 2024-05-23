package com.example.explicitintentdemo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtC= (EditText) findViewById(R.id.txtC);
                int tempC=Integer.parseInt(txtC.getText().toString());
                EditText editText=(EditText)findViewById(R.id.edtPlace);
                Intent intent =new Intent(MainActivity.this,FActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("TCMP", txtC.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}