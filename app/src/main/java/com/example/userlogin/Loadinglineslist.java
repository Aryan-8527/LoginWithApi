package com.example.userlogin;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userlogin.APi.LoadingLineListApi;
import com.example.userlogin.Adapters.LoadingLineListAdapter;
import com.example.userlogin.Models.LoadingLineListModel;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loadinglineslist extends AppCompatActivity {
     public static TextView number ;
     TextView customername , customerno ;
     ImageView qrimg ;
     TextView lines , totalqty ;

     private RecyclerView recyclerView;

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

        // fetch data loadingline through APi //

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.125.53.126:9222/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoadingLineListApi loadinglineApi = retrofit.create(LoadingLineListApi.class);
        Call<List<LoadingLineListModel>> call = loadinglineApi.getloadinglinemodel();
        call.enqueue(new Callback<List<LoadingLineListModel>>() {
            @Override
            public void onResponse(Call<List<LoadingLineListModel>> call, Response<List<LoadingLineListModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Loadinglineslist.this, response.code(), Toast.LENGTH_SHORT).show();
                    return ;
                }
                List<LoadingLineListModel> loadinglineModelList = response.body();
                String valuelist = String.valueOf(response.body().size());
                lines.setText("Lines: "+valuelist);
                LoadingLineListAdapter loadinglineadapter = new LoadingLineListAdapter(loadinglineModelList, Loadinglineslist.this );
                recyclerView.setAdapter(loadinglineadapter);
            }

            @Override
            public void onFailure(Call<List<LoadingLineListModel>> call, Throwable t) {
                Toast.makeText(Loadinglineslist.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Retrofit retrofits = new Retrofit.Builder()
                .baseUrl("http://103.125.53.126:9222/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoadingLineListApi loadinglineApis = retrofits.create(LoadingLineListApi.class);
        Call<List<LoadingLineListModel>> calls = loadinglineApis.getloadinglinemodel();
        calls.enqueue(new Callback<List<LoadingLineListModel>>() {
            @Override
            public void onResponse(Call<List<LoadingLineListModel>> call, Response<List<LoadingLineListModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Loadinglineslist.this, response.code(), Toast.LENGTH_SHORT).show();
                    return ;
                }
                List<LoadingLineListModel> loadinglineModelList = response.body();
                String valuelist = String.valueOf(response.body().size());
                lines.setText("Lines: "+valuelist);
                LoadingLineListAdapter loadinglineadapter = new LoadingLineListAdapter(loadinglineModelList, Loadinglineslist.this );
                recyclerView.setAdapter(loadinglineadapter);
            }

            @Override
            public void onFailure(Call<List<LoadingLineListModel>> call, Throwable t) {
                Toast.makeText(Loadinglineslist.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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



