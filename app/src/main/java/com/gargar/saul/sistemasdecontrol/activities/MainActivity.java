package com.gargar.saul.sistemasdecontrol.activities;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gargar.saul.sistemasdecontrol.R;
import com.gargar.saul.sistemasdecontrol.models.Light;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageView lightImage;
    private TextView lightState;
    private ProgressBar progressBar;
    private FloatingActionButton fabLight;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference("luces");
    private DatabaseReference refLuz = database.getReference("home/luces/luz_sala");

    private Light light = new Light(false, "1", "Luz de la sala");

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  findViewById(R.id.toolbar);
        lightImage = (ImageView) findViewById(R.id.image_light);
        lightState = (TextView) findViewById(R.id.light_state);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        fabLight = (FloatingActionButton) findViewById(R.id.fab_light);

        ref = FirebaseDatabase.getInstance().getReference();

        fabLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (light.getState()){

                   light.setState(false);
                   refLuz.setValue(false);
                   progressBar.setVisibility(View.INVISIBLE);

               }
               else {

                   light.setState(true);
                   refLuz.setValue(true);
                   progressBar.setVisibility(View.INVISIBLE);
               }
            }
        });

        refLuz.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Boolean state = Boolean.valueOf(dataSnapshot.getValue(String.class));
                light.setState(dataSnapshot.getValue(Boolean.class));
                setDataLigth(light);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        setToolbar();
        setDataLigth(light);

    }


    public void setToolbar(){
        toolbar.setTitle(light.getName());
        setSupportActionBar(toolbar);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setDataLigth(Light light){

        if (light.getState()){
            lightImage.setImageDrawable(getDrawable(R.drawable.ic_light_on));
            lightState.setText("Encendido");
            fabLight.setImageResource(R.drawable.ic_light_off);

        }
        else {
            lightImage.setImageDrawable(getDrawable(R.drawable.ic_light_off));
            lightState.setText("Apagado");
            fabLight.setImageResource(R.drawable.ic_light_on);
        }

        progressBar.setVisibility(View.INVISIBLE);
    }

}
