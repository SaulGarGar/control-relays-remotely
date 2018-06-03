package com.gargar.saul.sistemasdecontrol.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gargar.saul.sistemasdecontrol.R;
import com.gargar.saul.sistemasdecontrol.models.Light;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by saul on 31/05/18.
 */

public class LightRecyclerViewAdapter extends RecyclerView.Adapter<LightRecyclerViewAdapter.LightsViewHolder>{

    private ArrayList<Light> lights;
    private Context context;

    public static class LightsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageLight;
        private TextView textLight;

        public LightsViewHolder(View itemView) {
            super(itemView);

            imageLight = (ImageView) itemView.findViewById(R.id.image_light);
            textLight = (TextView) itemView.findViewById(R.id.text_light);

        }
    }

    public LightRecyclerViewAdapter(ArrayList<Light> lights, Context context) {
        this.lights = lights;
        this.context = context;
    }

    @Override
    public LightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_lights, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item pressed", Toast.LENGTH_SHORT).show();
            }
        });
        return new LightsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LightsViewHolder holder, int position) {

        Light light = lights.get(position);

        holder.textLight.setText(light.getName());

        Picasso.with(context)
                .load(R.drawable.ic_light_off)
                .into(holder.imageLight);

        holder.imageLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lights.size();
    }


}
