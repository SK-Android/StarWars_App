package com.androidapp.mcs.starwarsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.mcs.starwarsapp.adapter.StarWarsAdapter;
import com.androidapp.mcs.starwarsapp.model.StarWars;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvHeight, tvMass,tvDateTime;
    public Context context;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        StarWars starWars = getIntent().getExtras().getParcelable(StarWarsAdapter.ITEM_KEY);
        if (starWars != null) {
            Toast.makeText(this, "Recieved charaters\t" + starWars.getName(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Didnt recieve any data", Toast.LENGTH_SHORT).show();
            throw new AssertionError("Null data item recieved");
        }
        tvName = findViewById(R.id.name_tv);
        tvHeight = findViewById(R.id.height_tv);
        tvMass = findViewById(R.id.mass_tv);
        tvDateTime = findViewById(R.id.dateTime_tv);

        tvName.setText("Name: \t "+  starWars.getName());
        tvHeight.setText("Height in Meters: \t "+  starWars.getHeight());
        tvMass.setText("Mass in Kg: \t "+  starWars.getMass());
        tvDateTime.setText("Record Creation Date and Time: \t "+  starWars.getCreated());

    }
}
