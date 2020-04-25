package com.example.retrofitexapmple.repository.jsonplaceholderrepo.config;

import com.example.retrofitexapmple.repository.jsonplaceholderrepo.entity.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {
    @GET("/posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @GET("/posts/")
    Call<ArrayList<Post>> getPosts();
}
