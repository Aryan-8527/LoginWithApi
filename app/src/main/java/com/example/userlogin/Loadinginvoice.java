package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.userlogin.APi.LoadingInvoiceApi;
import com.example.userlogin.APi.LoadingQCApi;
import com.example.userlogin.Adapters.LoadingInvoiceAdapter;
import com.example.userlogin.Adapters.LoadingQCAdapter;
import com.example.userlogin.Models.LoadingInvoiceModel;
import com.example.userlogin.Models.LoadingQCModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loadinginvoice extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinginvoice);

        recyclerView = findViewById(R.id.recycler_loadinginvoice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.125.53.126:9222/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoadingInvoiceApi loadingInvoiceApi = retrofit.create(LoadingInvoiceApi.class);
        Call<List<LoadingInvoiceModel>> call = loadingInvoiceApi.getloadinginvoicemodel();

        call.enqueue(new Callback<List<LoadingInvoiceModel>>() {
            @Override
            public void onResponse(Call<List<LoadingInvoiceModel>> call, Response<List<LoadingInvoiceModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Loadinginvoice.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<LoadingInvoiceModel> loadinginvoiceModelList = response.body();
                LoadingInvoiceAdapter loadingInvoiceadapter = new LoadingInvoiceAdapter(loadinginvoiceModelList,Loadinginvoice.this );
                recyclerView.setAdapter(loadingInvoiceadapter);
            }

            @Override
            public void onFailure(Call<List<LoadingInvoiceModel>> call, Throwable t) {
                Toast.makeText(Loadinginvoice.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}