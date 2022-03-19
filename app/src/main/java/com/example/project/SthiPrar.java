package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SthiPrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sthi_prar);

        getSupportActionBar().setTitle("स्थितिजन्य प्रार्थना");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}