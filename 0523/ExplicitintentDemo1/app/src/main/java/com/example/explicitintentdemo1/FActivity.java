package com.example.explicitintentdemo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        converTempture();

        Button btnReturn=(Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void converTempture(){
        int c;
        double f=0.0;
        String place="";
        Bundle bundle=this.getIntent().getExtras();
        if(bundle!=null){
            c=bundle.getInt("TCMP",0);
            f=(9.0*c)/5.0+32.0;
            place=bundle.getString("PLACE", "");
            TextView output=(TextView) findViewById(R.id.lblOutput);
            output.setText(place+"\n華氏溫度："+Double.toString(f));
        }
    }
}