package com.acme.sqliteoperaciones;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;

    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.usuarioNombre);
        password = (EditText) findViewById(R.id.usuarioPassword);

        helper = new DbAdapter(this);
    }

    public void agregaUsuario(View view){
        String datoUsuario = usuario.getText().toString();
        String datoPassword = password.getText().toString();
        if(datoUsuario.isEmpty() || datoPassword.isEmpty()){
            Mensaje.aviso(this, "Ingrese tatnto el nombre como la contraseña");
        }else{
            long resultado  = helper.insertarDatos(datoUsuario, datoPassword);
            if(resultado <= 0){
                Mensaje.aviso(this, "Inserción fallida");
                usuario.setText("");
                password.setText("");
            }else{
                Mensaje.aviso(this, "Inserción Exitosa");
                usuario.setText("");
                password.setText("");
            }
        }

    }

    public void verDatos(View view){
        String datos = helper.getData();
        Mensaje.aviso(this, datos);
    }


}
