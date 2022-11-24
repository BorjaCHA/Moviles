package com.example.chaconborja1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.net.Uri;

public class Principal extends AppCompatActivity {

    TextView nombre;
    TextView apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellidos);

        llamarAnimacion(nombre);
        llamarAnimacion(apellido);

    }

    public void llamarAnimacion(View view){
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion1);

        nombre.startAnimation(animacion);
        apellido.startAnimation(animacion);
    }

    public void cambiarCalculadora (View view){
        Intent cambiarCalculadora= new Intent(this,Calculadora.class);

        startActivity(cambiarCalculadora);
        finish();

    }
    public void cambiarContacto (View view){
        Intent cambiarContacto = new Intent (this, Contacto.class);
        startActivity(cambiarContacto);
        finish();
    }
}