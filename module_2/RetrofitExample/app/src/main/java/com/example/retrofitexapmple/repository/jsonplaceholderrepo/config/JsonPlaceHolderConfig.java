package com.example.retrofitexapmple.repository.jsonplaceholderrepo.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonPlaceHolderConfig {

    private Retrofit retrofit;

    private static JsonPlaceHolderConfig jsonPlaceHolderConfig;

    private JsonPlaceHolderConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public JsonPlaceholderApi jsonPlaceholderApi() {
        return retrofit.create(JsonPlaceholderApi.class);
    }

    public static JsonPlaceHolderConfig getInstance() {
        if (jsonPlaceHolderConfig == null) {
            jsonPlaceHolderConfig = new JsonPlaceHolderConfig();
        }
        return jsonPlaceHolderConfig;
    }

}
