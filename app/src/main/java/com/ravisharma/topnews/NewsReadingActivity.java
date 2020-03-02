package com.ravisharma.topnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsReadingActivity extends AppCompatActivity {

    ProgressBar loader;
    ListView listnews;
    List<NewsModel> modelList = new ArrayList<>();
    NewsAdapter adapter;
    String passurl;
    String news_url;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_reading);
        title = (String) getIntent().getExtras().get("title");
        setTitle(title);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loader = (ProgressBar)findViewById(R.id.progress_news);
        listnews = (ListView)findViewById(R.id.list_news);
        listnews.setEmptyView(loader);

        news_url = (String) getIntent().getExtras().get("news");
        load_news();
    }
    private void load_news() {

        StringRequest request = new StringRequest(Request.Method.GET, news_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject childObject = jsonArray.getJSONObject(i);
                        passurl = childObject.getString("url");
                        NewsModel model = new NewsModel();
                        model.setAuthur(childObject.getString("author"));
                        model.setTitle(childObject.getString("title"));
                        model.setDescription(childObject.getString("description"));
                        model.setUrl(childObject.getString("url"));
                        model.setImage(childObject.getString("urlToImage"));
                        model.setTime(childObject.getString("publishedAt"));
                        modelList.add(model);
                    }
                    adapter = new NewsAdapter(NewsReadingActivity.this,R.layout.news_list_layout,modelList);
                    listnews.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsReadingActivity.this, "Error : "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(NewsReadingActivity.this);
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS*2,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
