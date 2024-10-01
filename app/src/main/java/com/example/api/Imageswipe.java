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
    TextView next,back;
    int p = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswipe);
        vpager = findViewById(R.id.vpager);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

        ModelClass all = (ModelClass)getIntent().getSerializableExtra("Data");
        int a = getIntent().getIntExtra("Int",0);

        all.getThumbnail();
        MyPage pg = new MyPage(this, all.images);
        vpager.setAdapter(pg);
        vpager.setCurrentItem(a);
        p = vpager.getCurrentItem();

//        vpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                p = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (p < pg.getCount() - 1) {
//                    p++;
//                    vpager.setCurrentItem(p);
//                }
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (p > 0) {
//                    p--;
//                    vpager.setCurrentItem(p);
//                }
//            }
//        });

//        next.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                p++;
//                vpager.setCurrentItem(p);
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                p--;
//                vpager.setCurrentItem(p);
//            }
//        });

    }
}