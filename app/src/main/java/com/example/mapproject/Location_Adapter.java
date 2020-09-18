package com.example.mapproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Location_Adapter extends RecyclerView.Adapter<Location_Adapter.ViewHolder>{

    Context mContext;
    ArrayList<Location> listLocation;

    public Location_Adapter(Context mContext, ArrayList<Location> listLocation) {
        this.mContext = mContext;
        this.listLocation = listLocation;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location location = listLocation.get(position);
        holder.tv_title.setText(location.getName().toString());
        holder.tv_disc.setText(location.getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return listLocation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_disc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.name);
            tv_disc = itemView.findViewById(R.id.title);
        }
    }
}
