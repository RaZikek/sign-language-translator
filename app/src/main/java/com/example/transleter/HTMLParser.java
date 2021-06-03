package com.example.transleter;


import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class HTMLParser {


    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        Document doc = Jsoup.connect("https://www.spreadthesign.com/ru.ru/search/?q=нет")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        Elements videoE = doc.select("div.search-result-content.well");
        System.out.println(videoE);


    }
}
