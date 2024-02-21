package com.example.stylemirror_1_1.Activity;

import com.example.stylemirror_1_1.Activity.amazonapiservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static amazonapiservice.AmazonApiService getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(amazonapiservice.AmazonApiService.class);
    }
}