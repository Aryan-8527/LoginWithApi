package com.example.userlogin;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.userlogin.Adapters.LoadingLineAdapter;
import com.example.userlogin.Models.LoadingLineModel;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Loadinglineslist extends AppCompatActivity {
     public static TextView number ;
     TextView customername , customerno ;
     ImageView qrimg ;
     TextView lines , totalqty ;
     RecyclerView recyclerView;
    ArrayList<LoadingLineModel> loadinglinemodel;
    LoadingLineAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglineslist);

        number = findViewById(R.id.tv_no);
        customername = findViewById(R.id.tv_customername);
        customerno = findViewById(R.id.tv_customerno);
        qrimg = findViewById(R.id.img_scanqr);
        lines = findViewById(R.id.tv_lines);
        totalqty = findViewById(R.id.tv_qty);


        recyclerView = findViewById(R.id.loadinglinerecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String no = intent.getStringExtra("listno");
        String Cname = intent.getStringExtra("customername");
        String Cno = intent.getStringExtra("customerno");
        customerno.setText(Cno);
        customername.setText(Cname);
        number.setText(no);

        String yourDocumentNo = no;

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://103.125.53.126:9222/api/LoadingLines?DocumentNo=" + yourDocumentNo;
        Log.d("Aryan", "onCreate: "+url);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<LoadingLineModel> list = new ArrayList<>();


                            for (int i = 0; i < jsonArray.length(); i++) {
                                String valuelist = String.valueOf(jsonArray.length());
                                lines.setText("Lines: "+valuelist);
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String Description_2 = jsonObject.getString("Description_2");
                                String Length = jsonObject.getString("Length");
                                String Quantity = jsonObject.getString("Quantity");
                                String Loading_Quantity = jsonObject.getString("Loading_Quantity");
                                String Remarks = jsonObject.getString("Remarks");
                                String Peices = jsonObject.getString("Peices");
                                String Pieces = jsonObject.getString("Pieces");

                                LoadingLineModel data = new LoadingLineModel(Description_2, Length, Quantity , Loading_Quantity,Remarks , Peices , Pieces  );
                                list.add(data);
                            }

                            LoadingLineAdapter adapter = new LoadingLineAdapter((ArrayList<LoadingLineModel>) list, Loadinglineslist.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Loadinglineslist.this, "Error to fetch Data", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);


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
            AlertDialog.Builder builder = new AlertDialog.Builder(Loadinglineslist.this);
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



