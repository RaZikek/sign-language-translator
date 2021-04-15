package com.example.transleter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Connect {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.spreadthesign.com/ru.ru/search/by-category/398/zhestovyi-iazyk-dlia-nachinaiushchikh/?q=&p=1").get();

        String answer = doc.body().text();

        Elements el = doc.select("div");
        String src = el.attr("src");

        System.out.println(src);
    }
}
