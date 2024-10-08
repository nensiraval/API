package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //GridView grid;
    RecyclerView recycle;

    ArrayList<ModelClass> allData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle = findViewById(R.id.recycle);

        RequestQueue que = Volley.newRequestQueue(MainActivity.this);
        StringRequest rs = new StringRequest(Request.Method.GET, "https://dummyjson.com/products", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject alldata = new JSONObject(response);

                    JSONArray product = alldata.getJSONArray("products");

                    for (int i = 0; i < product.length(); i++) {
                        JSONObject singleProduct = product.getJSONObject(i);
                        Integer id = singleProduct.getInt("id");
                        String tittle = singleProduct.getString("title");
                        String description = singleProduct.getString("description");
                        String category = singleProduct.getString("category");
                        double price = singleProduct.getDouble("price");
                        double discountPercentage = singleProduct.getDouble("discountPercentage");
                        double rating = singleProduct.getDouble("rating");
                        Integer stock = singleProduct.getInt("stock");

                        JSONArray jsonTags = singleProduct.getJSONArray("tags");
                        String[] tags = new String[jsonTags.length()];
                        for (int t = 0; t < jsonTags.length(); t++) {
                            tags[t] = jsonTags.getString(t);
                        }

//                        String brand = singleProduct.getString("brand");

                        JSONArray jsonReview = singleProduct.getJSONArray("reviews");
                        ArrayList<HashMap<String, Object>> reviews = new ArrayList<>();

                        for (int k = 0; k < jsonReview.length(); k++)
                        {
                            JSONObject reviewMap = jsonReview.getJSONObject(k);

                            HashMap<String, Object> hash = new HashMap<>();
                            hash.put("rating", reviewMap.getInt("rating"));
                            hash.put("comment", reviewMap.getString("comment"));
                            hash.put("date", reviewMap.getString("date"));
                            hash.put("reviewerName", reviewMap.getString("reviewerName"));
                            hash.put("reviewerEmail", reviewMap.getString("reviewerEmail"));
                            reviews.add(hash);
                        }
                        JSONArray jsoImages = singleProduct.getJSONArray("images");

                        ArrayList<String> images = new ArrayList<>();
                        for (int k = 0; k < jsoImages.length(); k++) {
                            images.add(jsoImages.getString(k));
                        }

                        String thumbnail = singleProduct.getString("thumbnail");

                        ModelClass modelClass = new ModelClass(id, tittle, description, category, price,
                                discountPercentage, rating, stock, tags, "brand", reviews, images, thumbnail);
                        allData.add(modelClass);



                    }
                } catch (JSONException e) {

                    Log.d("======t-----", "onResponse: " + e);
                }
                Log.e("==r==", "loop throw tittle value: "+allData.size());

                MyAdapter adapter = new MyAdapter(allData, MainActivity.this);
                recycle.setAdapter(adapter);


//                 Myclass db = new Myclass(allData, MainActivity.this);
//                grid.setAdapter(db);
               // Log.d("==r==", "tags : " + Arrays.toString(allData.get(0).getTags()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("--er--", "onErrorResponse: " + error.getLocalizedMessage());
            }
        });
        //main point
        que.add(rs);

        //3st step
        //RequestQueue ==> 1st
        //StringRequest ==> 2nd
        //RequestQueue no object que.add ("String no object");

    }
}