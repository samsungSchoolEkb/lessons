package com.example.fragmentnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] transitionIds = {R.id.blankFragment, R.id.blankFragment2, R.id.blankFragment3, R.id.blankFragment4};


        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Button prev = findViewById(R.id.button);
        Button next = findViewById(R.id.button2);

        navController.navigate(R.id.blankFragment);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter < transitionIds.length ) {
                    counter++;
                    navController.navigate(transitionIds[counter - 1]);
                }else{
                    counter = 0;
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
            }
        });
    }
}
