package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MalaV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mala_v);

        getSupportActionBar().setTitle("मला विनंती");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}