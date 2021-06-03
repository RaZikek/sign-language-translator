package com.example.transleter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button button;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Закрепление экрана
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        videoView = findViewById(R.id.videoView);
        button = findViewById(R.id.send);
        search = findViewById(R.id.search);
        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search.getText().toString().isEmpty()) {
                    Pref pref1 = new Pref();
                    pref1.execute();
                } else
                    Toast.makeText(MainActivity.this, "Введите слово", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Вывод видео
    public void changeUrl(String url) {
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }

    // AsyncTask
    class Pref extends AsyncTask<Void, String, String> {


        @Override
        protected String doInBackground(Void... voids) {
            SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            Document doc = null;

            String url = "https://www.spreadthesign.com/ru.ru/search/?q=";

            try {
                doc = Jsoup.connect(url + search
                        .getText()
                        .toString())
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = url + search.getText().toString();
            Elements videoE = doc.select("video");
            if (videoE != null) {
                String videoSearchUrl = videoE.attr("src");
                return videoSearchUrl;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s == null) {
                Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();
            }
            changeUrl(s);
        }
    }


}