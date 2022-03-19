package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DharmaV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharma_v);

        getSupportActionBar().setTitle("मिस्सा धर्माविधी");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}