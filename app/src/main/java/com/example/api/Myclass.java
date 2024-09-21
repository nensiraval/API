package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Myclass extends BaseAdapter {
    int[] draw;
    MainActivity mainActivity;
    String[] n;
    public Myclass(String[] n, int[] draw, MainActivity mainActivity) {
        this.draw =draw;
        this.mainActivity = mainActivity;
        this.n = n;
    }

    public Myclass(ArrayList<ModelClass> allData, MainActivity mainActivity) {
    }

    @Override
    public int getCount() {
        return n.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView im;
        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.images, parent, false);
        im = convertView.findViewById(R.id.image);
        im.setBackgroundResource(draw[position]);
        TextView txt;
        txt = convertView.findViewById(R.id.txt);
   //     txt.setText("HEllo");
        txt.setText(n[position]);
        return convertView;
    }
}
