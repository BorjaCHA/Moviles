package com.example.chaconborja1eva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {
    TextView puntu;
    SeekBar miControl;
    Button enviar;
    EditText  asunto, mensaje,incial;
    Button btonPrin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        btonPrin = findViewById(R.id.buttonPrin);
        miControl = findViewById(R.id.seekBar);
        incial = findViewById(R.id.textViewCor);
        puntu = findViewById(R.id.textViewPun);
        asunto = findViewById(R.id.textViewAsu);
        mensaje = findViewById(R.id.textViewMen);
        enviar = findViewById(R.id.buttonEnviar);
        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                puntu.setText("" + miControl.getProgress() + "/" + miControl.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String errores ="";

                String enviarCorreo = incial.getText().toString();
                if (enviarCorreo.isEmpty()|| !enviarCorreo.contains("@") || enviarCorreo.length()<4){
                    errores ="INTRODUCE UNA DIRECCION CORRECTA";
                    incial.setText("");

                }

                String enviarAsunto = asunto.getText().toString();
                String enviarMensaje = mensaje.getText().toString() + "\n Puntuacion: " + String.valueOf(puntu.getText());

                if (errores.isEmpty()){
                    if (asunto.length()<1){AlertDialog.Builder alerta = new AlertDialog.Builder(Contacto.this);
                        alerta.setMessage("DESEA ENVIAR EL CORREO SIN ASUNTO")
                                .setCancelable(true)
                                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        Intent intent = new Intent(android.content.Intent.ACTION_SEND);

                                        intent.setAction(Intent.ACTION_SEND);
                                        intent.setType("meesage/rfc822");


                                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{enviarCorreo});

                                        intent.putExtra(Intent.EXTRA_SUBJECT, enviarAsunto);
                                        intent.putExtra(Intent.EXTRA_TEXT, enviarMensaje);

                                        startActivity(Intent.createChooser(intent, "Send mail..."));


                                        finish();
                                        Log.e("Test email:", "Fin envio email");
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog titulo = alerta.create();
                        titulo.setTitle(errores);
                        titulo.show();

                    }

                    else{AlertDialog.Builder alerta2 = new AlertDialog.Builder(Contacto.this);
                        alerta2.setMessage(errores +" Desea continuar")
                                .setCancelable(true)
                                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        finish();
                                           }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });

                    }
                }

            }




            /*

                */


        });


    }

    public void CambiarVentana(View view){
        Intent CambiarVen = new Intent(this, Principal.class);
        startActivity(CambiarVen);

    }
}