package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("shamal","onCreate2");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal","onRestart2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal","onPause2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal","onStop2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal","onResume2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal","onStart2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal","onDestroy2");
    }

    public void onClickOpen(View view) {
        finishAffinity();
    }
}