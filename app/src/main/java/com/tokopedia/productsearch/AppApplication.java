package com.tokopedia.productsearch;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erry on 5/20/2016.
 */
public class AppApplication extends Application {
    public final String BASE_API_URL = "https://ajax.tokopedia.com/search/v1/";
    private static ApiEndpoint endpointInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                                .create()))
                .client(new OkHttpClient())
                .build();
        endpointInterface = retrofit.create(ApiEndpoint.class);
    }

    public static ApiEndpoint getEndpointInterface() {
        return endpointInterface;
    }
}
