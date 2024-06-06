package com.example.explicitintentdemo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int SET_RESULT = 1;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        EditText txtOpd1, txtOpd2;
        // 取得EditText元件
        txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
        txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
        // 建立Intent物件
        Intent intent = new Intent(this, OpActivity.class);
        // 建立傳遞資料的Bundle物件
        Bundle bundle = new Bundle();
        bundle.putString("OPERAND01",txtOpd1.getText().toString());
        bundle.putString("OPERAND02",txtOpd2.getText().toString());
        intent.putExtras(bundle);  // 加上資料
        // 啟動活動且有回傳資料
        startActivityForResult(intent, SET_RESULT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case SET_RESULT:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    output.setText("計算結果: " + bundle.getDouble("RESULT"));
                }
                break;
        }
    }
}
