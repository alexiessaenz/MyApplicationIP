package com.example.hdrdr.myapplicationip;
import control.nose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText etIp;
    private EditText etMask;
    private EditText etBroadcast; //objetos de tipo editText y button
    private EditText etnetId;
    private EditText etred;
    private EditText ethost;
    private EditText etnHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn);
        etIp = (EditText) findViewById(R.id.et_ip); // relacion de las id de los objetoss en la gui, con los objeto de la clase
        etMask = (EditText) findViewById(R.id.et_mask);
        etBroadcast = (EditText) findViewById(R.id.et_broad);
        etnetId = (EditText) findViewById(R.id.et_netId);
        etred = (EditText) findViewById(R.id.et_red);
        ethost = (EditText) findViewById(R.id.et_host);
        etnHost = (EditText) findViewById(R.id.et_nHost);



        btn1.setOnClickListener(new View.OnClickListener() { // edicion de los objetos Edittext de la interfaz de usuario
            @Override
            public void onClick(View v) {
                etBroadcast.setText(String.valueOf(nose.obtenerBroadcast(String.valueOf(etIp.getText()) , String.valueOf(etMask.getText()))));
                etnetId.setText(String.valueOf(nose.obtenerDireccionRed(String.valueOf(etIp.getText()) , String.valueOf(etMask.getText()))));
                etred.setText(String.valueOf(nose.cortarRed()));
                ethost.setText(String.valueOf(nose.cortarHost()));
                etnHost.setText(String.valueOf(nose.numerosHost(String.valueOf(etMask.getText()))));
            }
        });



    }
}
