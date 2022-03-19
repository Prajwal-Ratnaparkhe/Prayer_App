package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Vachan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vachan);

        getSupportActionBar().setTitle("स्थितिजन्य वचन");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}