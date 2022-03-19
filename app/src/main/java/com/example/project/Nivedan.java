package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Nivedan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivedan);

        getSupportActionBar().setTitle("प्रार्थना  निवेदन ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}