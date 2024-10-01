package com.example.api;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        holder.txtprice.setText("₹"+String.valueOf(model.getPrice()));
        holder.txtdis.setText(" "+String.valueOf(model.getDiscountPercentage()+ "%off"));

        int k = (int) (100 - model.getDiscountPercentage());
        int t = (int) (model.getPrice()*100);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.startActivity(new Intent(mainActivity, Imageswipe.class).
                        putExtra("Data",allData.get(position)));

            }
        });

        holder.txtrate.setText(String.valueOf(" "+t/k));
        holder.txtrating.setText(String.valueOf(model.getRating()+" ★ "));
        Glide.with(mainActivity).load(model.getThumbnail()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return allData.size();
    }
}
class Myrecycle extends RecyclerView.ViewHolder
{
    TextView txtittle,txtprice,txtrating,txtdis,txtrate;
    ImageView image;

    public Myrecycle(@NonNull View itemView)
    {
        super(itemView);
        txtittle = itemView.findViewById(R.id.txtittle);
        txtprice = itemView.findViewById(R.id.txtprice);
        txtrating = itemView.findViewById(R.id.txtrating);
        image = itemView.findViewById(R.id.image);
        txtrate = itemView.findViewById(R.id.txtrate);
        txtdis = itemView.findViewById(R.id.txtdis);


    }
}
