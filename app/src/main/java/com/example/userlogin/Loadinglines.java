package com.example.userlogin;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONException;
import org.json.JSONObject;

public class Loadinglines extends AppCompatActivity {
    TextView number , customername , customerno ;
    ImageView qrimg ;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglines);

        number = findViewById(R.id.tv_no);
        customername = findViewById(R.id.tv_customername);
        customerno = findViewById(R.id.tv_customerno);
        qrimg = findViewById(R.id.img_scanqr);
        recyclerView = findViewById(R.id.loadinglinerecyclerview);


        Intent intent = getIntent();
        String no = intent.getStringExtra("listno");
        String Cname = intent.getStringExtra("customername");
        String Cno = intent.getStringExtra("customerno");
        customerno.setText(Cno);
        customername.setText(Cname);
        number.setText(no);

            // QR code scanner //

        qrimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               scanCode();
            }
        });
    }



    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(Scannerview.class);
        barlauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barlauncher = registerForActivityResult(new  ScanContract() , result -> {

        if (result.getContents()!= null){
            AlertDialog.Builder builder = new AlertDialog.Builder(Loadinglines.this);
            builder.setMessage("Result");
            builder.setMessage(result.getContents());

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    });
}



