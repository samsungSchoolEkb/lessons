package com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback;

import com.example.retrofitexapmple.repository.jsonplaceholderrepo.entity.Post;

public interface PostCallback {
    void onResponse(Post post);

    void onEror(String errorText);
}
