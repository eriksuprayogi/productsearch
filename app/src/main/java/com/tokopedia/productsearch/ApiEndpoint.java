package com.tokopedia.productsearch;

import com.tokopedia.productsearch.model.ProductResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Erry on 5/20/2016.
 */
public interface ApiEndpoint {

//    @Headers({"Content-Type:application/json"})
    @GET("product?device=android")
    Call<ProductResponse> getProduct(@Query("rows") Integer rows, @Query("start") Integer start);
}
