package com.example.medicali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptery extends RecyclerView.Adapter<RecyclerViewAdaptery.MyViewHolder> {
    Context mcontext;
    List<row> mdata;

    public RecyclerViewAdaptery(Context mcontext, List<row> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public RecyclerViewAdaptery.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptery.MyViewHolder holder, int position) {
        Glide.with(mcontext).load(mdata.get(position).getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);

        }

        @Override
        public void onClick(View v) {

            if (getLayoutPosition() == 0) {
                Toast.makeText(mcontext, "You Clicked Me", Toast.LENGTH_SHORT).show();
                
            }

        }
    }
}
