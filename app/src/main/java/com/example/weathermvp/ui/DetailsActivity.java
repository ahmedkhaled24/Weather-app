package com.example.weathermvp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermvp.R;
import com.example.weathermvp.adapter.DetailsAdapter;
import com.example.weathermvp.customs.CustomDetails;
import com.example.weathermvp.data.InterfaceDetails;
import com.example.weathermvp.data.Presenter;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements InterfaceDetails {

    Presenter presenter;
    Double latt,lonn;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<CustomDetails> mydetails;
    String url = "https://openweathermap.org/img/w/";
    ProgressBar progress;
    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        progress = findViewById(R.id.progressBar2);
        mydetails = new ArrayList<>();


        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            city = extras.getString("city");
            latt = extras.getDouble("lat");
            lonn = extras.getDouble("lon");
        }

        getSupportActionBar().setTitle("  Forecast for "+city);

        // call presenter
        presenter = new Presenter(this);
        for (int i=1;i<6;i++){
            presenter.onGetDetailsPresenter(latt,lonn,this,i);
            progress.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onGetDetailsInterface(int id, Long date, String icon, Double tempMax, Double tempMin, String main, String desc, String timeZone) {
            String image =url+icon+".png";
            Double max = tempMax /10;
            int tMax = (int) Math.round(max);
            Double min = tempMin /10;
            int tMin = (int) Math.round(min);
            mydetails.add(new CustomDetails(id,date,image,tMax,tMin,main,desc,timeZone));
            recyclerView = findViewById(R.id.recycler);
//        Collections.sort(mydetails, new Comparator<CustomDetails>() {
//            @Override
//            public int compare(CustomDetails o1, CustomDetails o2) {
//                return Integer.compare( o2.getId(),o1.getId());
//            }
//        });
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            adapter = new DetailsAdapter(mydetails);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            progress.setVisibility(View.GONE);
    }


}