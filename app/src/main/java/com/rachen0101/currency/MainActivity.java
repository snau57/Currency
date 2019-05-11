package com.rachen0101.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_ntd;
    private Button bn_go;
    private TextView tv_ntd;
    private TextView tv_jpy;
    private TextView tv_usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_ntd = findViewById(R.id.ntd_in);
        bn_go = findViewById(R.id.go);
        tv_ntd = findViewById(R.id.ntd);
        tv_jpy = findViewById(R.id.jpy);
        tv_usd = findViewById(R.id.usd);
        Button rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exchange Rates")
                .setMessage("NTD : JPY = 1 : 0.28\nNTD : USD = 1 : 30.9")
                .setPositiveButton("OK", null)
                .show();
            }
        });
    }

    public void clickGo(View view) {
        String  n = ed_ntd.getText().toString();
        if (n.isEmpty()) {
            new AlertDialog.Builder(this)
            .setTitle("Problem")
            .setMessage("Please enter your NTD amount")
            .setPositiveButton("OK", null)
            .show();
        } else {
            float ntd = Float.parseFloat(n);
            float result_jpy = (float)(ntd / 0.28);
            float result_usd = (float)(ntd / 30.9);
            String nt = Float.toString(ntd);
            String jp = Float.toString(result_jpy);
            String us = Float.toString(result_usd);
            tv_ntd.setText(nt + " = ");
            tv_jpy.setText(jp);
            tv_usd.setText(us);
            new AlertDialog.Builder(this)
            .setTitle("Result")
            .setMessage("JPY is " + result_jpy + "\nUSD is " + result_usd)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ed_ntd.setText("");
                }
            })
            .show();
        }

    }
}
