package com.example.proyecto_base_2dauni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Info_act extends AppCompatActivity {

    private ImageButton gps, ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        gps = (ImageButton)findViewById(R.id.img_btt_gps);
        ws = (ImageButton)findViewById(R.id.img_btt_wasa);

    }

    //intent implicito
    public void maracdo(View view){
        Intent i = new Intent(Intent.ACTION_DIAL); //accion para el marcado
        i.setData(Uri.parse("tel:"+"971991201")); //maracado
        startActivity(i);
    }

    //intent implicito
    public void maps(View view){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}