package com.example.stylemirror_1_1.Activity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AmazonApiClient {
    private static final String BASE_URL = "https://vitototti.p.rapidapi.com/";
    private static AmazonApiClient instance;
    private amazonapiservice.AmazonApiService apiService;

    private AmazonApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(amazonapiservice.AmazonApiService.class);
    }

    public static AmazonApiClient getInstance() {
        if (instance == null) {
            instance = new AmazonApiClient();
        }
        return instance;
    }

    public amazonapiservice.AmazonApiService getApiService() {
        return apiService;
    }
}
