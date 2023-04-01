package com.example.userlogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final int MY_REQUEST_CODE1 = 1;
    private static final int MY_REQUEST_CODE2 = 2;
    private static final int MY_REQUEST_CODE3 = 3;

    TextView LOADINGLIST, LOADINGQC, LOADINGINVOICE;

    public TextView loadinglistapisize;
    public TextView loadingqcapisize;
    public TextView loadinginvoiceapisize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LOADINGLIST = findViewById(R.id.tv_loadinglist);
        LOADINGQC = findViewById(R.id.tv_loading_qc);
        LOADINGINVOICE = findViewById(R.id.tv_loading_invoice);
        loadinglistapisize = findViewById(R.id.tv_loadinglist_apilength);
        loadingqcapisize = findViewById(R.id.tv_loadingqc_apilength);
        loadinginvoiceapisize = findViewById(R.id.tv_loadinginvoice_apilength);


        loadinglistapisize.setText("2");
        loadingqcapisize.setText("15");
        loadinginvoiceapisize.setText("4229");

        LOADINGLIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list = new Intent(MainActivity2.this, Loadinglists.class);
                Toast.makeText(MainActivity2.this, "Loading lists Activity", Toast.LENGTH_SHORT).show();
                startActivity(list);
                startActivityForResult(list, MY_REQUEST_CODE1);
            }
        });

        LOADINGQC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qc = new Intent(MainActivity2.this, Loadingqc.class);
                Toast.makeText(MainActivity2.this, "Loading QC Activity", Toast.LENGTH_SHORT).show();
                startActivity(qc);
                startActivityForResult(qc, MY_REQUEST_CODE2);

            }
        });

        LOADINGINVOICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invoice = new Intent(MainActivity2.this, Loadinginvoice.class);
                Toast.makeText(MainActivity2.this, "Loading invoice Activity", Toast.LENGTH_SHORT).show();
                startActivity(invoice);
                startActivityForResult(invoice, MY_REQUEST_CODE3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == MY_REQUEST_CODE1) {
                if (data != null)
                    loadinglistapisize.setText(data.getStringExtra("list"));
            } else if (requestCode == MY_REQUEST_CODE2) {
                if (data != null)
                    loadingqcapisize.setText(data.getStringExtra("qc"));
            } else {
                if (requestCode == MY_REQUEST_CODE3) {
                    if (data != null)
                        loadinginvoiceapisize.setText(data.getStringExtra("invoice"));
                }
            }
        }
    }
}

