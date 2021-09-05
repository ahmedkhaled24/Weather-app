package com.example.weathermvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermvp.customs.CustomDetails;
import com.example.weathermvp.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private ArrayList<CustomDetails> myDetails;

    public DetailsAdapter(ArrayList<CustomDetails> myDetails) {
        this.myDetails = myDetails;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.details_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomDetails customDetails = myDetails.get(position);

        String transformedDate = new SimpleDateFormat("EEE, dd/MM/yyyy").format(new Date(customDetails.getDate()*1000));

        holder.tvDate.setText(transformedDate);
        holder.tvMax.setText(customDetails.getTempMax()+"");
        holder.tvMin.setText("/"+customDetails.getTempMin()+"°C");
        holder.tvMain.setText(customDetails.getMain());
        holder.tvDesc.setText(customDetails.getDesc());
        Picasso.get().load(customDetails.getIcon()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return myDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate,tvMax,tvMin,tvMain,tvDesc;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.textView_Date);
            tvMax = itemView.findViewById(R.id.textView_tempMax);
            tvMin = itemView.findViewById(R.id.textView_tempMin);
            tvMain = itemView.findViewById(R.id.textView_Main);
            tvDesc = itemView.findViewById(R.id.textView_desc);
            imageView = itemView.findViewById(R.id.imageViewC);
        }
    }
}
