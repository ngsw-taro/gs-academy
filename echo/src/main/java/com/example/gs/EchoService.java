package com.example.gs;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EchoService {

    @GET("/echo/{value}")
    Call<EchoResponse> echo(@Path("value") String value);
}
