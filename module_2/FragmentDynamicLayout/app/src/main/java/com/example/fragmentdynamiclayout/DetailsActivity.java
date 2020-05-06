package com.example.fragmentdynamiclayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            DetailsFragment details = new DetailsFragment();
            details.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}
