package com.example.proyecto_base_2dauni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Object_Class.Insumos;
import Object_Class.Usuarios;

public class MainActivity extends AppCompatActivity {

    private EditText userName, password;
    private TextView mensaje;
    private ProgressBar barra;
    private Button inicio, fin;
    private Usuarios usr = new Usuarios();
    private Insumos insumo = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.edt_userName);
        password = (EditText)findViewById(R.id.edt_passW);
        inicio = (Button)findViewById(R.id.btt_inicioS);
        fin = (Button)findViewById(R.id.btt_salirB);
        mensaje = (TextView)findViewById(R.id.txt_error);
        barra = (ProgressBar)findViewById(R.id.pb_inicio);

        userName.setText("");
        password.setText("");

        barra.setVisibility(View.INVISIBLE); //volver invisible

        //para tarea asincrona
        //sobre escribimos el onclick
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //correr tarea asincrona
                //configuramos lo de abajo primero
                new Task().execute(); //ejecuta la tarea asincrona
            }
        });
    }

    //tarea asincrona
    class Task extends AsyncTask<String, Void, String>{
        //define la configuracion inicial de mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }
        //realiza el proceso en segundo plano o mi tarea pesada
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++){
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        //finaliza tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //validacion en on postexecute
            //captura de valores ingrewsados por pantalla
            String usuario = userName.getText().toString().trim();
            String conraseña = password.getText().toString().trim();

            //valores del objeto usuario
            String userObj = usr.getName().trim();
            String passObj = usr.getPass().trim();

            switch (usuario){
                case "Juan":
                    if (usuario.equals(userObj) && conraseña.equals(passObj)){
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        //vaciar los campos de entrada
                        userName.setText("");
                        password.setText("");

                        //preparo los extras que seran enviados a insumos_act
                        Bundle bun = new Bundle(); //Creamos para enviar arreglo
                        bun.putStringArray("insumos", insumo.getInsumos()); // rellenamos el bundle
                        i.putExtras(bun); //enviamos el bundle a traves del intent

                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.equals("") && conraseña.isEmpty()){
                        mensaje.setText("Campos vacios, ingrese usuario y contraseña");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !conraseña.equals(passObj)){
                        mensaje.setText("Usuario o contraseña invalida, intente nuevamente.");
                    }
                    break;
            }

        }
    }




    public void facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //accion que abre un navegador
        i.setData(Uri.parse("https://www.facebook.com/")); //pasamos con el uri.parse la direccion de la pagina web
        startActivity(i); // iniciamos activity
    }
    public void twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //accion que abre un navegador
        i.setData(Uri.parse("https://www.twitter.com/")); //pasamos con el uri.parse la direccion de la pagina web
        startActivity(i); // iniciamos activity
    }
    public void youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //accion que abre un navegador
        i.setData(Uri.parse("https://www.youtube.com/")); //pasamos con el uri.parse la direccion de la pagina web
        startActivity(i); // iniciamos activity
    }

    public void info(View view){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}