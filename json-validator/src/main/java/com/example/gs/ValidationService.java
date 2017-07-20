package com.example.gs;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ValidationService {

    @GET("/")
    Call<Result> echo(@Query("json") String json);
}
