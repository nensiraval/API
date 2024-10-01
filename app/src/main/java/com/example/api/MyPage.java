package com.example.api;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyPage extends PagerAdapter {
    Imageswipe imageswipe;
    ArrayList<String> all;

    public MyPage(Imageswipe imageswipe, ArrayList<String> all) {
        this.imageswipe = imageswipe;
        this.all = all;
    }

    @Override
    public int getCount() {
        return all.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView vtext;

        View vv = LayoutInflater.from(imageswipe).inflate(R.layout.swipe, null, false);
        vtext = vv.findViewById(R.id.vtext);

        Glide.with(imageswipe).load(all.get(position)).into(vtext);
        container.addView(vv);
        return vv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
