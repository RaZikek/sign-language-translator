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
            editor.putString("машина", "https://media.spreadthesign.com/video/mp4/12/345841.mp4");
            editor.putString("hell", "https://media.spreadthesign.com/video/mp4/12/349210.mp4");
            editor.putString("address", "https://media.spreadthesign.com/video/mp4/12/4380.mp4");
            editor.putString("asia", "https://media.spreadthesign.com/video/mp4/12/351481.mp4");
            editor.putString("ameriсa", "https://media.spreadthesign.com/video/mp4/12/349176.mp4");
            editor.putString("england", "https://media.spreadthesign.com/video/mp4/12/16122.mp4");
            editor.putString("nice smell", "https://media.spreadthesign.com/video/mp4/12/349232.mp4");
            editor.putString("africa", "https://media.spreadthesign.com/video/mp4/12/12723.mp4");
            editor.apply();
            startActivity(i);
        }
    }
}