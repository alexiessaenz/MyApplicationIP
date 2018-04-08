package com.example.hdrdr.myapplicationip;
import control.nose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText etIp;
    private EditText etMask;
    private EditText etBroadcast;
    private EditText etnetId;
    private EditText etred;
    private EditText ethost;
    private EditText etnHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn);
        etIp = (EditText) findViewById(R.id.et_ip);
        etMask = (EditText) findViewById(R.id.et_mask);
        etBroadcast = (EditText) findViewById(R.id.et_broad);
        etnetId = (EditText) findViewById(R.id.et_netId);
        etred = (EditText) findViewById(R.id.et_red);
        ethost = (EditText) findViewById(R.id.et_host);
        etnHost = (EditText) findViewById(R.id.et_nHost);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //String q= etIp.getText();
            //String w= "";
                //tv1.setText(Integer.toString(counterA));
                //nose.calcular(String.valueOf(etIp.getText()) , String.valueOf(etMask.getText()));
                //etIp.setText("gh");
                etBroadcast.setText(String.valueOf(nose.obtenerBroadcast(String.valueOf(etIp.getText()) , String.valueOf(etMask.getText()))));
                etnetId.setText(String.valueOf(nose.obtenerDireccionRed(String.valueOf(etIp.getText()) , String.valueOf(etMask.getText()))));
                etred.setText(String.valueOf(nose.cortarRed()));
                ethost.setText(String.valueOf(nose.cortarHost()));
                etnHost.setText(String.valueOf(nose.cortarHost()));
                //etBroadcast.setText("dffdfddf");


            }
        });



    }
}
