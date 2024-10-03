package com.example.api;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Imageswipe extends AppCompatActivity {

    ViewPager vpager;

    TextView[] textViews;
    TextView next, back, detittle, deprice, derate, dedis, derating, details;
    int p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswipe);

        vpager = findViewById(R.id.vpager);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        detittle = findViewById(R.id.detittle);
        deprice = findViewById(R.id.deprice);
        derate = findViewById(R.id.derate);
        dedis = findViewById(R.id.dedis);
        derating = findViewById(R.id.derating);
        details = findViewById(R.id.details);

        ModelClass all = (ModelClass) getIntent().getSerializableExtra("Data");

        String Tittle = all.getTittle();
        detittle.setText(Tittle);

        String Price = ("₹" + String.valueOf(all.getPrice()));
        deprice.setText(Price);

        String Discount = (" " + String.valueOf(all.getDiscountPercentage() + "%off"));
        dedis.setText(Discount);

        int k = (int) (100 - all.getDiscountPercentage());
        int t = (int) (all.getPrice() * 100);

        String Rate = (String.valueOf(" " + t / k));
        derate.setText(Rate);

        String Rating = String.valueOf(all.getRating() + " ★ ");
        derating.setText(Rating);

        String Detail = all.getDescription();
        Log.d("===d====", "onCreate: " + all.images);
        details.setText(Detail);

        MyPage pg = new MyPage(this, all.images);

        vpager.setAdapter(pg);
        p = vpager.getCurrentItem();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p < all.images.size()) {
                    p++;
                    vpager.setCurrentItem(p);
                } else {
                    Log.d("====", "Next : " + p);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p > 0) {
                    p--;
                    vpager.setCurrentItem(p);
                }
                Log.d("====", "Back : " + p);
            }
        });
    }
}