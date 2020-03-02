package com.ravisharma.topnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] name = {"Latest News", "Business", "Sports", "Entertainment", "Science", "Technology", "Health"};
    String[] slogan = {"World Wide BBC News", "India Business News", "Indian Sports News", "Bollywood Hot News", "Science News",
            "Tech updates", "Health Care tips"};
    Integer[] image = {R.drawable.news,
            R.drawable.business,
            R.drawable.sport,
            R.drawable.enter,
            R.drawable.science,
            R.drawable.tech,
            R.drawable.health};

    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_main);
        adapter = new ListAdapter(this, name, slogan, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent all = new Intent(MainActivity.this, NewsReadingActivity.class);
                        all.putExtra("title", "BBC World Wide");
                        all.putExtra("news", "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(all);
                        break;
                    case 1:
                        Intent business = new Intent(MainActivity.this, NewsReadingActivity.class);
                        business.putExtra("title", "Business News");
                        business.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(business);
                        break;
                    case 2:
                        Intent sport = new Intent(MainActivity.this, NewsReadingActivity.class);
                        sport.putExtra("title", "Sports Update");
                        sport.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(sport);
                        break;
                    case 3:
                        Intent enter = new Intent(MainActivity.this, NewsReadingActivity.class);
                        enter.putExtra("title", "Entertainment");
                        enter.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(enter);
                        break;
                    case 4:
                        Intent science = new Intent(MainActivity.this, NewsReadingActivity.class);
                        science.putExtra("title", "Science Updates");
                        science.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(science);
                        break;
                    case 5:
                        Intent tech = new Intent(MainActivity.this, NewsReadingActivity.class);
                        tech.putExtra("title", "Technology updates");
                        tech.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(tech);
                        break;
                    case 6:
                        Intent health = new Intent(MainActivity.this,NewsReadingActivity.class);
                        health.putExtra("title", "Health Tips");
                        health.putExtra("news", "https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=9519a92dcd774539a770fa5e12957082");
                        startActivity(health);
                        break;
                }
            }
        });
    }
}
