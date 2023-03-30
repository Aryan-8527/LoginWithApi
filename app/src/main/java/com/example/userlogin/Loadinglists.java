package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.userlogin.APi.LoadingListApi;
import com.example.userlogin.Adapters.LoadingListAdapter;
import com.example.userlogin.Models.LoadingListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loadinglists extends AppCompatActivity {

    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglists);

        recyclerView = findViewById(R.id.recycler_loadinglist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.125.53.126:9222/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LoadingListApi loadingListApi = retrofit.create(LoadingListApi.class);
        Call<List<LoadingListModel>> call = loadingListApi.getloadinglistmodel();

        call.enqueue(new Callback<List<LoadingListModel>>() {
            @Override
            public void onResponse(Call<List<LoadingListModel>> call, Response<List<LoadingListModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Loadinglists.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<LoadingListModel> loadingListModelList = response.body();

                String valuelist = String.valueOf(response.body().size());
                Intent intent = new Intent();
                intent.putExtra("list", valuelist);
                setResult(RESULT_OK , intent);

                LoadingListAdapter loadinglistadapter = new LoadingListAdapter(loadingListModelList,Loadinglists.this );
                recyclerView.setAdapter(loadinglistadapter);
            }

            @Override
            public void onFailure(Call<List<LoadingListModel>> call, Throwable t) {
                Toast.makeText(Loadinglists.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}