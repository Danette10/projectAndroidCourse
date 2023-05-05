package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    private TextView myTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.hello_activity);

        this.myTextView = findViewById(R.id.txt1);

        String value = getIntent().getStringExtra("user");
        this.myTextView.setText(value);

    }
}
