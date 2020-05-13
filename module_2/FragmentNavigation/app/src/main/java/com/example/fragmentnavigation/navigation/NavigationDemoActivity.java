package com.example.fragmentnavigation.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.fragmentnavigation.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class NavigationDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_demo);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bttom_navigation_view);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        if (bottomNavigationView != null) {
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }

        if (navigationView != null) {
            NavigationUI.setupWithNavController(navigationView, navController);
        }
    }
}
