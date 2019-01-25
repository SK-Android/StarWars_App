package com.androidapp.mcs.starwarsapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.androidapp.mcs.starwarsapp.adapter.StarWarsAdapter;
import com.androidapp.mcs.starwarsapp.model.StarWars;
import com.androidapp.mcs.starwarsapp.service.WebService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    RecyclerView recyclerView;
    public StarWars starWarsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        WebService webService = WebService.retrofit.create(WebService.class);
        Call<StarWars> call = webService.getDataItems();
        call.enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(@NonNull Call<StarWars> call, @NonNull Response<StarWars> response) {
                pDialog.dismiss();
                starWarsList = response.body();
                assert starWarsList != null;
                Toast.makeText(MainActivity.this, "Received\t"+starWarsList.getResults().size()+"\tStar wars characters from Service", Toast.LENGTH_SHORT).show();
                displayData();
            }

            @Override
            public void onFailure(@NonNull Call<StarWars> call, @NonNull Throwable t) {
                Log.d("onFailure: ", t.getMessage());
            }
        });
    }

    private void displayData() {
        if(starWarsList != null)
        {
            StarWarsAdapter starWarsAdapter = new StarWarsAdapter(starWarsList, this);
            recyclerView.setAdapter(starWarsAdapter);
        }
    }
}
