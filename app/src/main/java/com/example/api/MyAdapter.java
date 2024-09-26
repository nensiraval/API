package com.example.api;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<Myrecycle>
{
    ArrayList<ModelClass> allData;
    MainActivity mainActivity;

    public MyAdapter(ArrayList<ModelClass> allData, MainActivity mainActivity) {
        this.allData = allData;
        this.mainActivity = mainActivity;
    }

    //view create
    @NonNull
    @Override
    public Myrecycle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View vv =  LayoutInflater.from(mainActivity).inflate(R.layout.images, parent, false);
       Myrecycle myrecycle = new Myrecycle(vv);

        return myrecycle;
    }

    @Override
    public void onBindViewHolder(@NonNull Myrecycle holder, int position) {
        Log.d("=====", "onBindViewHolder: "+position);
        ModelClass model = allData.get(position);
        holder.txtittle.setText(model.getTittle());
        holder.txtprice.setText("₹"+String.valueOf(model.getPrice())+"  "+String.valueOf(model.getDiscountPercentage()));
        holder.txtrating.setText(String.valueOf(model.getRating())+" ★ ");
    }

    @Override
    public int getItemCount() {
        return allData.size();
    }
}
class Myrecycle extends RecyclerView.ViewHolder{

    TextView txtittle,txtprice,txtrating;
    public Myrecycle(@NonNull View itemView)
    {
        super(itemView);
        txtittle = itemView.findViewById(R.id.txtittle);
        txtprice = itemView.findViewById(R.id.txtprice);
        txtrating = itemView.findViewById(R.id.txtrating);

    }
}
