package com.example.weathermvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermvp.customs.MainItem;
import com.example.weathermvp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private ArrayList<MainItem> myList;
    private RecyclerViewClickListener listener;

    public ItemAdapter(ArrayList<MainItem> myList, RecyclerViewClickListener listener) {
        this.myList = myList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainItem mainItem = myList.get(position);
        holder.tvCity_Country.setText(mainItem.getString());
        holder.currentTemp.setText(mainItem.getTemp() + "°C");
        Picasso.get().load(mainItem.getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCity_Country,currentTemp;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCity_Country = itemView.findViewById(R.id.city_id);
            currentTemp = itemView.findViewById(R.id.currentTemp);
            imageView = itemView.findViewById(R.id.imageIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }


}
