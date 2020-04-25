package com.example.retrofitexapmple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitexapmple.repository.jsonplaceholderrepo.JsonPlaceholderRepository;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback.PostCallback;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.callback.PostsCallback;
import com.example.retrofitexapmple.repository.jsonplaceholderrepo.entity.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonPlaceholderRepository.getPostById(5, new PostCallback() {
            @Override
            public void onResponse(Post post) {
                Log.d("RETROFIT", "Пост: " + post.toString());
            }

            @Override
            public void onEror(String errorText) {

            }
        });

        JsonPlaceholderRepository.getPosts(new PostsCallback() {
            @Override
            public void onResponse(ArrayList<Post> post) {
                Log.d("RETROFIT", "Список постов: " + post.toString());
            }

            @Override
            public void onEror(String errorText) {

            }
        });
    }
}
