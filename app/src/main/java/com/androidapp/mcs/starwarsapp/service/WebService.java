package com.androidapp.mcs.starwarsapp.service;

import com.androidapp.mcs.starwarsapp.model.StarWars;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface WebService {

    String BASE_URL = "https://swapi.co/";
    String FEED = "api/people/?format=json";

    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<StarWars> getDataItems();
}
