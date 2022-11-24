package com.example.chaconborja1eva;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity  {

 TextView textResultado;
 Button btonCero;
 Button btonUno;
 Button btonDos;
 Button btonTres;
 Button btonCuatro;
 Button btonCinco;
 Button btonSeis;
 Button btonSiete;
 Button btonOcho;
 Button btonNueve;
 Button btonComa;
 Button btonMas;
 Button btonMenos;
 Button btonDivision;
 Button btonMultiplicacion;
 Button btonBorrar;
 Button btonIgual;
 ExpresionRegular expresionRegular;



boolean clickSignoMas, clickSignoMenos, clickSignoDivision, clickSignoMultiplicacion, clickSeparadorDecimal;

int operador ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        textResultado = findViewById(R.id.textResult);
        expresionRegular = new ExpresionRegular();

        btonCero = findViewById(R.id.buttonCero);
        btonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "0");
            }
        });
        btonUno = findViewById(R.id.buttonUno);
        btonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "1");
                accionesActuales(R.id.buttonUno);
            }
        });
        btonDos = findViewById(R.id.butttonDos);
        btonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "2");
                accionesActuales(R.id.butttonDos);
            }
        });
        btonTres = findViewById(R.id.buttonTres);
        btonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "3");
                accionesActuales(R.id.buttonTres);
            }
        });
        btonCuatro = findViewById(R.id.buttonCuatro);
        btonCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "4");
                accionesActuales(R.id.buttonCuatro);
            }
        });
        btonCinco = findViewById(R.id.buttonCinco);
        btonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "5");
                accionesActuales(R.id.buttonCinco);
            }
        });
        btonSeis= findViewById(R.id.buttonSeis);
        btonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "6");
                accionesActuales(R.id.buttonSeis);
            }
        });
        btonSiete = findViewById(R.id.buttonSiete);
        btonSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "7");
                accionesActuales(R.id.buttonSiete);
            }
        });
        btonOcho = findViewById(R.id.buttonOcho);
        btonOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "8");
                accionesActuales(R.id.buttonOcho);
            }
        });
        btonNueve = findViewById(R.id.buttonNueve);
        btonNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnterior = textResultado.getText().toString();
                textResultado.setText(textAnterior + "9");
                accionesActuales(R.id.buttonNueve);
            }
        });
        btonBorrar = findViewById(R.id.buttonBorrar);
        btonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textResultado.setText("");
                accionesActuales(R.id.buttonBorrar);
            }
        });
        btonMas = findViewById(R.id.buttonSum);
        btonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (textoAnterior.length() > 0 && clickSignoMas == false){

                    if( textoAnterior.endsWith("x")
                    || textoAnterior.endsWith("/")
                    || textoAnterior.endsWith("-")){
                        textoAnterior = textoAnterior.substring(0,textoAnterior.length()-1);
                        textResultado.setText(textoAnterior);
                    }
                    textResultado.setText(textoAnterior + "+");
                    clickSignoMas = true;
                    accionesActuales(R.id.buttonSum);
                }
            }
        });
        btonMenos = findViewById(R.id.buttonRest);
        btonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (clickSignoMenos == false){
                    if( textoAnterior.endsWith("x")
                            || textoAnterior.endsWith("/")
                            || textoAnterior.endsWith("+")){
                        textoAnterior = textoAnterior.substring(0,textoAnterior.length()-1);
                        textResultado.setText(textoAnterior);
                    }
                    textResultado.setText(textoAnterior + "-");
                    clickSignoMas = true;
                    accionesActuales(R.id.buttonRest);
                }

            }
        });
        btonMultiplicacion = findViewById(R.id.buttonMul);
        btonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (clickSignoMultiplicacion == false){
                    if( textoAnterior.endsWith("+")
                            || textoAnterior.endsWith("/")
                            || textoAnterior.endsWith("-")){
                        textoAnterior = textoAnterior.substring(0,textoAnterior.length()-1);
                        textResultado.setText(textoAnterior);
                    }
                    textResultado.setText(textoAnterior + "x");
                    clickSignoMultiplicacion = true;
                    accionesActuales(R.id.buttonMul);
                }

            }
        });
        btonDivision = findViewById(R.id.buttonDiv);
        btonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (clickSignoDivision == false){
                    if( textoAnterior.endsWith("x")
                            || textoAnterior.endsWith("+")
                            || textoAnterior.endsWith("-")){
                        textoAnterior = textoAnterior.substring(0,textoAnterior.length()-1);
                        textResultado.setText(textoAnterior);
                    }
                    textResultado.setText(textoAnterior + "/");
                    clickSignoDivision = true;
                    accionesActuales(R.id.buttonDiv);
                }

            }
        });
        btonComa = findViewById(R.id.buttonComa);
        btonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (clickSeparadorDecimal == false){
                    textResultado.setText(textoAnterior + ".");
                    clickSeparadorDecimal= true;
                    accionesActuales(R.id.buttonComa);
                }

            }
        });
        btonIgual = findViewById(R.id.buttonIg);
        btonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (textoAnterior.trim().length()>0){
                     String resultado = expresionRegular.resolverFormula(textoAnterior.trim());
                     textResultado.setText(resultado);
                }
                accionesActuales(R.id.buttonIg);

            }
        });



    }


    private void accionesActuales (int idBotonActual){
        if (idBotonActual != R.id.buttonSum){
            clickSignoMas = false;
        }
        if(idBotonActual != R.id.buttonRest){
            clickSignoMenos = false;

        }
        if(idBotonActual != R.id.buttonMul){
            clickSignoMultiplicacion = false;

        }
        if(idBotonActual != R.id.buttonDiv){
            clickSignoDivision = false;

        }
        if ( idBotonActual == R.id.buttonRest
        || idBotonActual == R.id.buttonSum
        || idBotonActual == R.id.buttonDiv
        || idBotonActual == R.id.buttonMul){
            clickSeparadorDecimal = false;
        }
    }
}