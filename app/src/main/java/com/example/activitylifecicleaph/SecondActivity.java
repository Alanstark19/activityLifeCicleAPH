package com.example.activitylifecicleaph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //constant for the LOG_TAG variable
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    //mensaje mediante clave-valor, es public para poder usarla también en la MainActivity
    public static final String EXTRA_REPLY = "com.example.activitylifecicleaph.extra.REPLAY";
    //Creamos variable de tipo EditText para guardar el msj que escriba el usuario
    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "onCreate");
        // creamos un objeto intent y usamos el método getIntent que nos devolvera un intent
        // si es que hay alguno creado
        Intent intent = getIntent();
        //Obtenemos mediante la primera activity el mensaje de nuestra variable clave-valor
        // el cual es el id del mensaje adicional
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //text_message es el id de la caja de texto donde se
        //escribirá el msj recibido de la MainActivity
        TextView textView = findViewById(R.id.text_message);
        //asignamos la variable con el msj recuperado con el método .set
        textView.setText(message);
        //editText_second es el id de la caja de texto donde se
        //escribió el msj de respuesta
        mReplay = findViewById(R.id.editText_second);
    }//fin del método onCreate
    @Override
    public void onStart(){
        super.onStart(); //haciendo referencia a un método de la superclase
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    /**
     * Método para regresar a la MainActivity
     * @param view objeto de tipo View
     */
    public void returnReply(View view) {
        //obtenemos la cadena de la variable mReply
        String reply = mReplay.getText().toString();
        //el intent nos ayudará a pasar de una activity a otra
        Intent replyIntent = new Intent();
        /*método que recibe una llave en String para identificar lo que le llegará a la otra activity*/
        //objeto editText(reply)/sacamos el msj que escribio el usuario
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        //log statement
        Log.d(LOG_TAG, "End SecondActivity");
        finish();//cerramos la activity
    }//fin del método returnReply
}//fin de la clase SecondActivity