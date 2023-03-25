package com.example.userlogin.APi;

import com.example.userlogin.Models.LoadingListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoadingListApi {

    @GET("LoadingList")
    Call<List<LoadingListModel>> getloadinglistmodel ();

}
