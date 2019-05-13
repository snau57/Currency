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

    private EditText edNtd;
    private Button bnGo;
    private TextView tvNtd;
    private TextView tvJpy;
    private TextView tvUsd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNtd = findViewById(R.id.ntd_in);
        bnGo = findViewById(R.id.go);
        tvNtd = findViewById(R.id.ntd);
        tvJpy = findViewById(R.id.jpy);
        tvUsd = findViewById(R.id.usd);
        Button rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.exchange_rates)
                .setMessage(getString(R.string.ntd) + " : " + getString(R.string.jpy) + " = 1 : 0.28\n" +
                        getString(R.string.ntd) + " : " + getString(R.string.usd) + " = 1 : 30.9")
                .setPositiveButton(R.string.ok, null)
                .show();
            }
        });
    }

    public void clickGo(View view) {
        String  n = edNtd.getText().toString();
        if (n.isEmpty()) {
            new AlertDialog.Builder(this)
            .setTitle(R.string.problem)
            .setMessage(R.string.your_ntd_amount)
            .setPositiveButton(R.string.ok, null)
            .show();
        } else {
            float ntd = Float.parseFloat(n);
            float resultJpy = (float)(ntd / 0.28);
            float resultUsd = (float)(ntd / 30.9);
            String nt = Float.toString(ntd);
            String jp = Float.toString(resultJpy);
            String us = Float.toString(resultUsd);
            tvNtd.setText(nt + " = ");
            tvJpy.setText(jp);
            tvUsd.setText(us);
            new AlertDialog.Builder(this)
            .setTitle(R.string.result)
            .setMessage(getString(R.string.jpy_is) + " " + resultJpy + "\n" +
                    getString(R.string.usd_is) + " " + resultUsd)
            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    edNtd.setText("");
                }
            })
            .show();
        }

    }
}
