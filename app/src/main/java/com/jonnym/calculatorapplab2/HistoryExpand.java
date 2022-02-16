package com.jonnym.calculatorapplab2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryExpand extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = findViewById(R.id.expandedHistory);
        textView.setText(getIntent().getStringExtra("extra"));
    }
}
