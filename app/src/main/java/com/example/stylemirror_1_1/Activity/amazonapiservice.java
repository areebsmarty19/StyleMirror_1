package com.example.stylemirror_1_1.Activity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public class amazonapiservice {


    public interface AmazonApiService {
        @GET("v1/products/")
        Call<ProductResponse> getProductDetails(
                @Query("apiKey") String apiKey,
                @Query("asin") String asin
        );
        @GET("v1/products/")
        Call<ProductResponse> getProductDetailsById(@Query("apiKey") String apiKey, @Query("id") String productId);
    }

        AmazonApiService create(Class<AmazonApiService> amazonApiServiceClass);
    }
}
