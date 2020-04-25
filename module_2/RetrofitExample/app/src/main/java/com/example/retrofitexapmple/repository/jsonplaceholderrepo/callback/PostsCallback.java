package com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback;

import com.example.retrofitexapmple.repository.jsonplaceholderrepo.entity.Post;

import java.util.ArrayList;

public interface PostsCallback {
    void onResponse(ArrayList<Post> post);

    void onEror(String errorText);
}
