package com.example.userlogin.APi;


import com.example.userlogin.Models.LoadingLineListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoadingLineListApi  {

    @GET("LoadingLines?DocumentNo=LS222300001589")
    Call<List<LoadingLineListModel>> getloadinglinemodel();

    @GET("LoadingLines?DocumentNo=LS222300001597")
    Call<List<LoadingLineListModel>> getmodelsline();

}
