package com.example.userlogin.APi;

import com.example.userlogin.Models.LoadingQCModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoadingQCApi {

    @GET("LoadingQC")
    Call<List<LoadingQCModel>> getqcmodel();
}
