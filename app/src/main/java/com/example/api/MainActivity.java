package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

public class MainActivity extends AppCompatActivity {
    Button dn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dn = findViewById(R.id.dn);

        //3st step
        //RequestQueue ==> 1st
        //StringRequest ==> 2nd
        //RequestQueue no object que.add ("String no object");

        ArrayList<Modelclass> datalist = new ArrayList<>();

        dn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RequestQueue que = Volley.newRequestQueue(MainActivity.this);
                StringRequest rs = new StringRequest(Request.Method.GET, "https://dummyjson.com/products", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject alldata = new JSONObject(response);
                           // Log.e("==r==", "All url print: "+alldata);

                            JSONArray product = alldata.getJSONArray("products");
                           // Log.e("==r==", "Product remove : "+product);

                            for (int i=0; i<product.length(); i++) {
                                JSONObject singleProduct = product.getJSONObject(0);
                                //          Log.e("==r==", "Array kadhi ne khali object ape(Hashmap): "+singleProduct);

                                String tittle = singleProduct.getString("title");
                                //   Log.e("==r==", "tittle ni value : "+tittle);

                                String ds = singleProduct.getString("description");
                               // Log.e("==r==", "onResponse: "+ds);

                               Log.e("==r==", "loop throw tittle value: "+i + tittle);
                            }
                        } catch (JSONException e) {
                            Log.e("==r==", "onResponse: "+e);
                        }

                        //a response thi akho array print thay
                      //  Log.e("==r==", "All array print: "+response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("--er--", "onErrorResponse: "+error.getLocalizedMessage());
                    }
                });
                //main point
                que.add(rs);
            }
        });
    }
}