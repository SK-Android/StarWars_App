package com.androidapp.mcs.starwarsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.mcs.starwarsapp.DetailActivity;
import com.androidapp.mcs.starwarsapp.R;
import com.androidapp.mcs.starwarsapp.model.StarWars;

import java.util.List;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.ViewHolder> {

    public static final String ITEM_KEY = "Item Key";
    private StarWars starWars;
    private Context mContext;

    //Constructor
    public StarWarsAdapter(StarWars starWars, Context mContext) {
        this.starWars = starWars;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final StarWars starWars1 = starWars.getResults().get(i);
        viewHolder.charName.setText(starWars1.getName());

        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(mContext, "You selected "+starWars1.getName(), Toast.LENGTH_SHORT).show();

                Intent  intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(ITEM_KEY, starWars1);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return starWars.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView charName;
        public View mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            charName = itemView.findViewById(R.id.textView);
            mView = itemView;
        }
    }
}
