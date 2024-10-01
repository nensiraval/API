////package com.example.api;
////
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class Myclass extends BaseAdapter {
////    int[] draw;
//    MainActivity mainActivity;
////    String[] n;
////    public Myclass(String[] n, int[] draw, MainActivity mainActivity)
////    {
//////        this.draw =draw;
//////        this.mainActivity = mainActivity;
////        this.n = n;
////    }
//    ArrayList<ModelClass> allData;
//    public Myclass(ArrayList<ModelClass> allData, MainActivity mainActivity) {
//        this.allData = allData;
//        this.mainActivity = mainActivity;
//    }
//
//    @Override
//    public int getCount() {
//        return allData.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return allData.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return (long) position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView im;
//        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.images, parent, false);
////        im = convertView.findViewById(R.id.image);
////        im.setBackgroundResource(draw[position]);
//        TextView txt;
//        txt = convertView.findViewById(R.id.txt);
//       // txt.setText(allData.get(position).getId());
//        txt.setText(allData.get(position).getTittle());
//        //txt.setText(allData.get(position).getDescription());
//        return convertView;
//    }
//}
