package com.tokopedia.productsearch;

import com.tokopedia.productsearch.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Erry on 5/20/2016.
 */
public interface ApiEndpoint {

    @Headers({"Content-Type:application/json"})
    @GET("inbox")
    Call<ProductResponse> getProduct();
}
