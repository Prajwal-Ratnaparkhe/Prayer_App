package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Novena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novena);

        getSupportActionBar().setTitle("नोवेना प्रार्थना");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}