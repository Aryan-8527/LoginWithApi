package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    TextView LOADINGLIST , LOADINGQC , LOADINGINVOICE ;

    TextView loadinglistapisize , loadingqcapisize , loadinginvoiceapisize ;


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



        LOADINGLIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list = new Intent(MainActivity2.this , Loadinglists.class);
                Toast.makeText(MainActivity2.this, "Its a loading lists Activity", Toast.LENGTH_SHORT).show();
                startActivity(list);
            }
        });

        LOADINGQC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qc = new Intent(MainActivity2.this , Loadingqc.class);
                Toast.makeText(MainActivity2.this, "Its a loading QC Activity", Toast.LENGTH_SHORT).show();
                startActivity(qc);
            }
        });

        LOADINGINVOICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invoice = new Intent(MainActivity2.this , Loadinginvoice.class);
                Toast.makeText(MainActivity2.this, "Its a Loading invoice Activity", Toast.LENGTH_SHORT).show();
                startActivity(invoice);
            }
        });
    }
}