package com.example.transleter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        pref = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Intent i = new Intent(StartActivity.this, MainActivity.class);

        if (pref.contains("first")){
            startActivity(i);
        }else {
            editor.putBoolean("first", true);
            editor.putString("car", "https://media.spreadthesign.com/video/mp4/12/345841.mp4");
            editor.apply();
            startActivity(i);
        }
    }
}