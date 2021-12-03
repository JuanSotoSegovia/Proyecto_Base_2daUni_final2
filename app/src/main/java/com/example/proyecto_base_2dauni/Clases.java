package com.example.proyecto_base_2dauni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_base_2dauni.dataBase.AdminSQLiteOpenHelper;

public class Clases extends AppCompatActivity {

    private EditText code, clase, intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = (EditText)findViewById(R.id.code);
        clase = (EditText)findViewById(R.id.clas);
        intensi = (EditText)findViewById(R.id.inten);
    }

    public void guardarClases (View view){
        //insertar datos
        //nos traemos el constructor para instanciar (obtenemos base de datos)
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"biofit",null,1);
        //damos permisos de sobre escritura
        SQLiteDatabase db = admin.getWritableDatabase();

        //recolectamos los datos ingrewsados
        String codigo = code.getText().toString();
        String clasee = clase.getText().toString();
        String intens = intensi.getText().toString();

        //validacion de campos vacios
        if(!codigo.isEmpty() && !clasee.isEmpty() && !intens.isEmpty()){
            ContentValues cont = new ContentValues(); //contener valores
            //nombre en base de datos y nombre a rellenar
            cont.put("codigo",codigo);
            cont.put("clase",clasee);
            cont.put("intensidad",intens);

            db.insert("clases", null, cont);
            limpiarCampos();
            db.close();
            Toast.makeText(getBaseContext(), "Has Guardado Una Clase", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(), "rellene campos", Toast.LENGTH_LONG).show();
        }
    }

    public void mostrarClases (View view){
        //mostrar datos
        //nos traemos el constructor para instanciar (obtenemos base de datos)
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"biofit",null,1);
        //damos permisos de sobre escritura
        SQLiteDatabase db = admin.getWritableDatabase();

        //recolectamos los datos ingrewsados
        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){
            //consultar el producto
            Cursor file = db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo="+codigo,null);

            if (file.moveToFirst()){ //verifica si hay valores asociados
                //mosramos daos segun posicion de consulta
                clase.setText(file.getString(0));
                intensi.setText(file.getString(1));
            }else{
                Toast.makeText(getBaseContext(), "no hay clase asociada", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "rellene el codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarClases (View view){
        //insertar datos
        //nos traemos el constructor para instanciar (obtenemos base de datos)
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"biofit",null,1);
        //damos permisos de sobre escritura
        SQLiteDatabase db = admin.getWritableDatabase();

        //recolectamos los datos ingrewsados
        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){
            //nombre bd, where
            db.delete("clases","codigo="+codigo,null);
            db.close();
            limpiarCampos();
            Toast.makeText(getBaseContext(), "has eliminado una clase: "+codigo, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(), "rellene el codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarClases (View view){
        //insertar datos
        //nos traemos el constructor para instanciar (obtenemos base de datos)
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"biofit",null,1);
        //damos permisos de sobre escritura
        SQLiteDatabase db = admin.getWritableDatabase();

        //recolectamos los datos ingrewsados
        String codigo = code.getText().toString();
        String clasee = clase.getText().toString();
        String intens = intensi.getText().toString();

        //validacion de campos vacios
        if(!codigo.isEmpty() && !clasee.isEmpty() && !intens.isEmpty()){
            //actualizamos
            ContentValues cont = new ContentValues(); //contener valores
            //nombre en base de datos y nombre a rellenar
            cont.put("clase",clasee);
            cont.put("intensidad",intens);

            db.update("clases",cont,"codigo="+codigo,null);
            limpiarCampos();
            db.close();
            Toast.makeText(getBaseContext(), "Has actulizado el codigo: "+codigo, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(), "rellene campos", Toast.LENGTH_LONG).show();
        }
    }

    public void limpiarCampos (){
        code.setText("");
        clase.setText("");
        intensi.setText("");
    }
}