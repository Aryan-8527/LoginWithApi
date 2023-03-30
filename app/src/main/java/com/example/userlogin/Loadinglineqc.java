package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Loadinglineqc extends AppCompatActivity {
    TextView qcnumbers , qccustomernames , qccustomernos ;
    ImageView qcqrimgs ;
    TextView qcliness , qctotalqtys ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglineqc);

        qcnumbers = findViewById(R.id.tv_qcno);
        qccustomernames = findViewById(R.id.tv_qccustomername);
        qccustomernos = findViewById(R.id.tv_qccustomerno);
        qcqrimgs =findViewById(R.id.img_qcscanqr);
        qcliness = findViewById(R.id.tv_qclines);
        qctotalqtys = findViewById(R.id.tv_qcqty);

        Intent intent = getIntent();
        String qno = intent.getStringExtra("qcno");
        String qCname = intent.getStringExtra("qccustomername");
        String qCno = intent.getStringExtra("qccustomerno");
        qccustomernos.setText(qCno);
        qccustomernames.setText(qCname);
        qcnumbers.setText(qno);
    }
}