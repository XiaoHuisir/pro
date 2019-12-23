package com.example.chiefinformation.model.api;



import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MyApi {
    @GET("index")
    Flowable<String> getIndexData();







}
