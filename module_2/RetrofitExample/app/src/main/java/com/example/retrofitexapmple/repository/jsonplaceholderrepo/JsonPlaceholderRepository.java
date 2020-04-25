package com.example.retrofitexapmple.repository.jsonplaceholderrepo;

import com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback.PostCallback;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback.PostsCallback;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.config.JsonPlaceHolderConfig;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.config.JsonPlaceholderApi;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.entity.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonPlaceholderRepository {
    private static final JsonPlaceholderApi api = JsonPlaceHolderConfig.getInstance().jsonPlaceholderApi();

    public static void getPostById(int id, PostCallback postCallback) {
        api.getPostById(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                postCallback.onResponse(post);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postCallback.onEror(t.getLocalizedMessage());
            }
        });
    }

    public static void getPosts(PostsCallback postsCallback) {
        api.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                ArrayList<Post> postList = response.body();
                postsCallback.onResponse(postList);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}
