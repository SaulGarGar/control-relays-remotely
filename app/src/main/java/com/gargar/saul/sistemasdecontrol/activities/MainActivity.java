package com.gargar.saul.sistemasdecontrol.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gargar.saul.sistemasdecontrol.R;
import com.gargar.saul.sistemasdecontrol.adapters.LightRecyclerViewAdapter;
import com.gargar.saul.sistemasdecontrol.models.Light;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private LightRecyclerViewAdapter adapter;
    private GridLayoutManager layoutManager;

    private ArrayList<Light> lights = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  findViewById(R.id.toolbar);

        recyclerView =  findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        setToolbar();

    }

    public void setToolbar(){
        toolbar.setTitle("Control relays");
        setSupportActionBar(toolbar);

    }

}
