package com.example.proyecto_base_2dauni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Object_Class.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView videohome;
    private Insumos in = new Insumos();


    //Cico de vida: onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videohome = (VideoView)findViewById(R.id.vw);

        //rura para llamar el video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri =  Uri.parse(ruta); //parseo la ruta

        videohome.setVideoURI(uri);

        //inicio video automatico
        videohome.start();

        //contrales para el video
        //MediaController media = new MediaController(this);
        //videohome.setMediaController(media);


    }

    public void insumos(View view){
        Intent i = new Intent(getBaseContext(), Insumos_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("insumos", in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }


}