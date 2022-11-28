package com.example.chaconborja1eva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {
    TextView puntu;
    SeekBar miControl;
    Button enviar;
    EditText asunto, mensaje, incial;
    Button btonPrin;
    ImageView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        etiqueta = (ImageView) findViewById(R.id.imageView4);
        registerForContextMenu(etiqueta);

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
                Intent intent = new Intent(Intent.ACTION_SEND);

                String enviarCorreo = incial.getText().toString();
                String enviarAsunto = asunto.getText().toString();
                String enviarMensaje = mensaje.getText().toString() + "\n Puntuacion: " + String.valueOf(puntu.getText());

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{enviarCorreo});
                intent.putExtra(Intent.EXTRA_SUBJECT, enviarAsunto);
                intent.putExtra(Intent.EXTRA_TEXT, enviarMensaje);

                if(enviarCorreo.equals("") || enviarAsunto.equals("") || enviarMensaje.toString().equals("")){
                    Toast.makeText(Contacto.this, "FALTAN CAMPOS OBLIGATORIOS (CORREO, ASUNTO O MENSAJE)", Toast.LENGTH_LONG).show();
                }
                else {
                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent, "ELIJA LA APLICACION PARA ENVIAR EL CORREO : "));
                }

            }




            });


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

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent volver = new Intent(this, Principal.class);
        startActivity(volver);
    }



}