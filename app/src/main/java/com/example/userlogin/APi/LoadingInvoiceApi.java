package com.example.userlogin.APi;

import com.example.userlogin.Models.LoadingInvoiceModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoadingInvoiceApi {

    @GET("LoadingInvoice")
    Call<List<LoadingInvoiceModel>> getloadinginvoicemodel();
}
