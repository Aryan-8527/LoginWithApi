package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.userlogin.APi.LoadingListApi;
import com.example.userlogin.APi.LoadingQCApi;
import com.example.userlogin.Adapters.LoadingListAdapter;
import com.example.userlogin.Adapters.LoadingQCAdapter;
import com.example.userlogin.Models.LoadingListModel;
import com.example.userlogin.Models.LoadingQCModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loadingqc extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingqc);

        recyclerView = findViewById(R.id.recycler_loadingQC);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.125.53.126:9222/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoadingQCApi loadingQCApi = retrofit.create(LoadingQCApi.class);
        Call<List<LoadingQCModel>> call = loadingQCApi.getqcmodel();

        call.enqueue(new Callback<List<LoadingQCModel>>() {
            @Override
            public void onResponse(Call<List<LoadingQCModel>> call, Response<List<LoadingQCModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Loadingqc.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<LoadingQCModel> loadingQCModelList = response.body();
                LoadingQCAdapter loadingQCadapter = new LoadingQCAdapter(loadingQCModelList,Loadingqc.this );
                recyclerView.setAdapter(loadingQCadapter);
            }

            @Override
            public void onFailure(Call<List<LoadingQCModel>> call, Throwable t) {
                Toast.makeText(Loadingqc.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}