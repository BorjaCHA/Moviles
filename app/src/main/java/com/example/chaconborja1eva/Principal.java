package com.example.chaconborja1eva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Principal extends AppCompatActivity {

    TextView nombre;
    ImageView etiqueta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);


        llamarAnimacion(nombre);

        etiqueta = (ImageView) findViewById(R.id.imageView2);
        registerForContextMenu(etiqueta);

    }



    public void llamarAnimacion(View view) {
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion1);

        nombre.startAnimation(animacion);

    }


    public void cambiarCalculadora(View view) {
        Intent cambiarCalculadora = new Intent(this, Calculadora.class);

        startActivity(cambiarCalculadora);
        finish();

    }

    public void cambiarContacto(View view) {
        Intent cambiarContacto = new Intent(this, Contacto.class);
        startActivity(cambiarContacto);
        finish();
    }


@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("SELECCIONE LA PANTALLA DONDE QUIERA IR ");
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menuprin, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnOp1:
                Intent intent1 = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent1);
                return true;

            case R.id.MnOp2:
                Intent intent2 = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent2);
                return true;

            case R.id.MnOp3:
                Intent intent3 = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}