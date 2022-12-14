package com.example.chaconborja1eva;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {

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
    Button btonCuadrado;
    ImageView etiqueta;
    ExpresionRegular expresionRegular;


    boolean clickSignoMas, clickSignoMenos, clickSignoDivision, clickSignoMultiplicacion, clickSeparadorDecimal;

    int operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        textResultado = findViewById(R.id.textResult);
        expresionRegular = new ExpresionRegular();
        etiqueta = (ImageView) findViewById(R.id.imageView3);
        registerForContextMenu(etiqueta);

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
        btonSeis = findViewById(R.id.buttonSeis);
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
                if (textoAnterior.length() > 0 && clickSignoMas == false) {

                    if (textoAnterior.endsWith("x")
                            || textoAnterior.endsWith("/")
                            || textoAnterior.endsWith("-")) {
                        textoAnterior = textoAnterior.substring(0, textoAnterior.length() - 1);
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
                if (clickSignoMenos == false) {
                    if (textoAnterior.endsWith("x")
                            || textoAnterior.endsWith("/")
                            || textoAnterior.endsWith("+")) {
                        textoAnterior = textoAnterior.substring(0, textoAnterior.length() - 1);
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
                if (clickSignoMultiplicacion == false) {
                    if (textoAnterior.endsWith("+")
                            || textoAnterior.endsWith("/")
                            || textoAnterior.endsWith("-")) {
                        textoAnterior = textoAnterior.substring(0, textoAnterior.length() - 1);
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
                if (clickSignoDivision == false) {
                    if (textoAnterior.endsWith("x")
                            || textoAnterior.endsWith("+")
                            || textoAnterior.endsWith("-")) {
                        textoAnterior = textoAnterior.substring(0, textoAnterior.length() - 1);
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
                if (clickSeparadorDecimal == false) {
                    textResultado.setText(textoAnterior + ".");
                    clickSeparadorDecimal = true;
                    accionesActuales(R.id.buttonComa);
                }

            }
        });
        btonCuadrado = findViewById(R.id.buttonCuadrado);
        btonCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double textoAnterior = Double.parseDouble(textResultado.getText().toString());
                String resultado = String.valueOf((textoAnterior) * (textoAnterior));
                textResultado.setText(resultado);
            }
        });
        btonIgual = findViewById(R.id.buttonIg);
        btonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAnterior = textResultado.getText().toString();
                if (textoAnterior.trim().length() > 0) {
                    String resultado = expresionRegular.resolverFormula(textoAnterior.trim());
                    textResultado.setText(resultado);
                }
                accionesActuales(R.id.buttonIg);

            }
        });


    }

    public void invertir(View view) {
        String invertir = "";
        for (int i = textResultado.length() - 1; i >= 0; i--) {
            invertir += textResultado.getText().charAt(i);
        }

        textResultado.setText(invertir);
    }


    private void accionesActuales(int idBotonActual) {
        if (idBotonActual != R.id.buttonSum) {
            clickSignoMas = false;
        }
        if (idBotonActual != R.id.buttonRest) {
            clickSignoMenos = false;

        }
        if (idBotonActual != R.id.buttonMul) {
            clickSignoMultiplicacion = false;

        }
        if (idBotonActual != R.id.buttonDiv) {
            clickSignoDivision = false;

        }
        if (idBotonActual == R.id.buttonRest
                || idBotonActual == R.id.buttonSum
                || idBotonActual == R.id.buttonDiv
                || idBotonActual == R.id.buttonMul) {
            clickSeparadorDecimal = false;
        }
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
            case R.id.MnOp1_1:
                Intent intent1 = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent1);
                return true;
            case R.id.MnOp1_2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://web2.0calc.es")));
                return true;
            case R.id.MnOp2_1:
                Intent intent2 = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent2);
                return true;
            case R.id.MnOp2_2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com/mail/help/intl/es/about.html?iframe")));
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