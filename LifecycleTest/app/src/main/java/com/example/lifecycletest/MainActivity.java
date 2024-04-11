package com.example.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private  static String TAG="LifeCycleTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "OnStart!");
        super.onStart();
    }
    @Override
    protected void onRestart() {
        Log.v(TAG, "OnRestart!");
        super.onRestart();
    }
    @Override
    protected void onPause() {
        Log.v(TAG, "OnPause!");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.v(TAG, "OnStop!");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.v(TAG, "OnDestroy!");
        super.onDestroy();
    }
}