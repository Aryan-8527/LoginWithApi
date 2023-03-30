package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Loadinglineinvoice extends AppCompatActivity {

    TextView invoicenumbers , invoicecustomernames , invoicecustomernos ;
    ImageView invoiceqrscan ;
    TextView invoiceline , invoiceqty ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglineinvoice);

        invoicenumbers = findViewById(R.id.tv_invoiceno);
        invoicecustomernames = findViewById(R.id.tv_invoicecustomername);
        invoicecustomernos = findViewById(R.id.tv_invoicecustomerno);
        invoiceqrscan = findViewById(R.id.img_invoicescanqr);
        invoiceline = findViewById(R.id.tv_invoicelines);
        invoiceqty = findViewById(R.id.tv_invoiceqcqty);

        Intent intent = getIntent();
        String ino = intent.getStringExtra("invoiceno");
        String iCname = intent.getStringExtra("invoicecustomername");
        String iCno = intent.getStringExtra("invoicecustomerno");
        invoicenumbers.setText(ino);
        invoicecustomernames.setText(iCname);
        invoicecustomernos.setText(iCno);

    }
}