package com.example.proyecto_base_2dauni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Object_Class.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView txt_resultado;
    private RatingBar rt;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = (Spinner)findViewById(R.id.spn_insumos);
        txt_resultado = (TextView)findViewById(R.id.txt_calculoInsu);
        rt = (RatingBar)findViewById(R.id.rtb_pro);

        //recivo extras desde mainactivity
        Bundle bun = getIntent().getExtras(); //obtengo los valores del intent y los guardo en un bundle
        String[] listado = bun.getStringArray("insumos");

        //Rellenado de spinner
        ArrayAdapter adapterInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adapterInsumos);
    }

    public void calcular (View view){


        String opcion = insumos.getSelectedItem().toString();
        int resultado = 0;
        int adicional = 0;

        for (int i = 0; 1 < opcion.length(); i++){
            if (opcion.equals(in.getInsumos()[i])){

                resultado = in.getPrecios()[i];
                adicional = in.getAdicional()[i];

                //trabajar como regla de negocios
                int Total = resultado+adicional;

                rt.setRating(i+1);

                txt_resultado.setText("La opciona es: " + opcion +
                                        "\nEl precio es de: $" + Total);
                break;
            }

        }
    }
}